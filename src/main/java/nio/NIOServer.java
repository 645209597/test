package nio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOServer extends Thread {
	
    public void run() {
    	
    	// IO
    	try {
    		ServerSocket serverSocket = new ServerSocket(0);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	// NIO
        try (Selector selector = Selector.open(); ServerSocketChannel serverSocket = ServerSocketChannel.open()) 
        {
            serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocket.configureBlocking(false);
            // 注册到 Selector，并说明关注点
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                selector.select();// 阻塞等待就绪的 Channel，这是关键点之一
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectedKeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    // 生产系统中一般会额外进行就绪状态检查
                    sayHelloWorld((ServerSocketChannel) key.channel());
                    iter.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // AIO
        try {
			AsynchronousServerSocketChannel serverSock = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
			serverSock.accept(serverSock, new CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>() { // 为异步操作指定 CompletionHandler 回调函数
			    @Override
			    public void completed(AsynchronousSocketChannel sockChannel, AsynchronousServerSocketChannel serverSock) {
			        serverSock.accept(serverSock, this);
			        // 另外一个 write（sock，CompletionHandler{}）
			        // sayHelloWorld(sockChannel, Charset.defaultCharset().encode("Hello World!"));
			    }

			    @Override
				public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    
    private void sayHelloWorld(ServerSocketChannel server) throws IOException {
        try (SocketChannel client = server.accept();) {          
        	client.write(Charset.defaultCharset().encode("Hello world!"));
        }
    }
    
    class RequestHandler extends Thread {
        
    	private Socket socket;
        
        RequestHandler(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(socket.getOutputStream());) {
                out.println("Hello world!");
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
     }
    
}
