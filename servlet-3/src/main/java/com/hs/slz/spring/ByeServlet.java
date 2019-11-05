//package com.hs.slz;
//
//import java.io.IOException;
//import javax.servlet.AsyncContext;
//import javax.servlet.AsyncEvent;
//import javax.servlet.AsyncListener;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class ByeServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        String s="goodBye";
//        AsyncContext asyncContext = req.startAsync();
//        asyncContext.addListener(new AsyncListener() {
//            @Override
//            public void onComplete(AsyncEvent asyncEvent) throws IOException {
//                System.out.println("onComplete");
//            }
//
//            @Override
//            public void onTimeout(AsyncEvent asyncEvent) throws IOException {
//                System.out.println("onTimeout");
//            }
//
//            @Override
//            public void onError(AsyncEvent asyncEvent) throws IOException {
//                System.out.println("onError");
//            }
//
//            @Override
//            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
//                System.out.println("onStartAsync");
//            }
//        });
//
//        asyncContext.start(new MyRunnable(asyncContext));
//
//        resp.getWriter().println("goodBye");
//    }
//
//    public static class MyRunnable implements Runnable {
//
//        AsyncContext asyncContext;
//
//        MyRunnable(AsyncContext asyncContext) {
//            this.asyncContext = asyncContext;
//        }
//
//        @Override
//        public void run() {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("goodBye!");
//            asyncContext.complete();
//        }
//    }
//}
