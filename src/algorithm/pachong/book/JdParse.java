package algorithm.pachong.book;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JdParse {
    public static List<Book> getData (String html) throws Exception{
        //获取的数据，存放在集合中
        List<Book> data = new ArrayList<Book>();
        //采用Jsoup解析
        Document doc = Jsoup.parse(html);
        //获取html标签中的内容
        Elements elements=doc.select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
        for (Element ele:elements) {
            String bookID=ele.attr("data-sku");
            String bookPrice=ele.select("div[class=p-price]").select("strong").select("i").text();
            String bookName=ele.select("div[class=p-name]").select("em").text();
            //创建一个对象，这里可以看出，使用Model的优势，直接进行封装
            Book Book=new Book();
            //对象的值
            Book.setBookId(bookID);
            Book.setBookName(bookName);
            Book.setBookPrice(bookPrice);
            //将每一个对象的值，保存到List集合中
            data.add(Book);
        }
        //返回数据
        return data;
    }
}