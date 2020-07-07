package com.hs.slz.spring;

import java.util.List;
import java.util.Map;

public class Page {
     String head;
     Body body;

    static class Body{
        List<Mark> marks;
//        ```
    }
    static class Mark {
        private String name;//"h1"
        private Map<String,String> attributtes;// [style='font-size: 12px',```]
        private String value;// "Welcome to Amazon"
        public Mark(String name){
            this.name=name;
        }
    }
    static class MarkWithChildren extends Mark{
        private List<Mark> marks;

        public MarkWithChildren(String name) {
            super(name);
        }
    }



    public static void main(String[] args) {
        String xml="<head>...</head>\n" +
                " <body>\n" +
                "   <h1 style='font-size: 12px' >Welcome to Amazon</h1>\n" +
                "   <h2>Hello world</h2>\n" +
                "   ...\n" +
                " </body>";
//        1.xmlParser parse this xml -> node
//         2. node->Page.class -> page
//        3.get the attribute of "body" from page
//        4.transfer the body(str) to Body.class ->page
//        5.page.value -> welcome to

        Page page = new Page();
        Body body = new Body();
        Mark mark1=new Mark("h1");
        Mark mark2 = new Mark("h2");
        Mark mark3=new Mark("div");
        Mark mark4=new Mark("");
        page.body=body;

    }
}
