<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>当当网首页</title>
    <link href="css/global.css" rel="stylesheet" type="text/css" />
    <link href="css/layout.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<!--随滚动条滚动可关闭广告-->
<div id="right" class="right">
    <div class="dd_close" id="dd_close"><a href="javascript:void(0);">关闭</a></div>
    <img src="images/dd_scroll.jpg" id="right1" />
</div>
<!--头部iframe引入-->
<div id="header">
    <iframe src="header.jsp" height="155px" width="960px" frameborder="0"></iframe>
</div>
<!--网站中间内容开始-->
<div id="main">
    <div class="dd_index_top_adver"><img src="images/dd_index_top_adver.jpg" alt="通栏广告图片" /></div>
    <!--左侧菜单开始-->
    <div id="catList">
        <!--推荐分类-->
        <div class="book_sort">
            <div class="book_sort_bg">推荐分类</div>
            <div class="book_sort_bottom" style="border-bottom:0px;">外语 | 中小学教辅 |</div>
        </div>
        <!--图书商品分类开始-->
        <div class="book_sort">
            <div class="book_sort_bg"><img src="images/dd_book_cate_icon.gif" alt="图书" /> 图书商品分类</div>
            <div class="book_cate">[小说]</div>
            <div class="book_sort_bottom">悬疑 | 言情 | 职场 | 财经</div>
            <div class="book_cate">[文艺]</div>
            <div class="book_sort_bottom">文学 | 传记 | 艺术 | 摄影</div>
            <div class="book_cate">[青春]</div>
            <div class="book_sort_bottom">青春文学 | 动漫 | 幽默</div>
            <div class="book_cate">[励志/成功]</div>
            <div class="book_sort_bottom">修养 | 成功 | 职场 | 沟通</div>
            <div class="book_cate">[少儿]</div>
            <div class="book_sort_bottom">0-2 | 3-6 | 7-10 | 11-14<br />文学 | 科普 | 图画书</div>
            <div class="book_cate">[生活]</div>
            <div class="book_sort_bottom">保健 | 家教 | 美丽装扮 | 育儿 | 美食 | 旅游 | 收藏 | 生活 | 体育 | 地图 | 个人理财</div>
            <div class="book_cate">[个人社科]</div>
            <div class="book_sort_bottom">文化 | 历史 | 哲学/宗教 | 古籍 | 政治/历史 | 法律 | 经济 | 社会科学 | 心理学</div>
            <div class="book_cate">[管理]</div>
            <div class="book_sort_bottom">管理 | 金融 | 营销 | 会计</div>
            <div class="book_cate">[科技]</div>
            <div class="book_sort_bottom">科普 | 建筑 | 医学 | 计算机 | 农林 | 自然科学 | 工业 | 通信</div>
            <div class="book_cate">[教育]</div>
            <div class="book_sort_bottom">教材 | 中小学教辅 | 外语</div>
            <div class="book_cate">[工具书]</div>
            <div class="book_cate">[图外原版书]</div>
            <div class="book_cate">[期刊]</div>
        </div>
        <!--图书商品分类结束-->
    </div>
    <!--左侧菜单结束-->
    <!--中间部分开始-->
    <div id="content">
        <!--轮换显示的横幅广告图片-->
        <div class="scroll_top"></div>
        <div class="scroll_mid">
            <ul id="scroll_img">
                <li><img src="images/dd_scroll_1.jpg"/></li>
                <li><img src="images/dd_scroll_2.jpg"/></li>
                <li><img src="images/dd_scroll_3.jpg"/></li>
                <li><img src="images/dd_scroll_4.jpg"/></li>
                <li><img src="images/dd_scroll_5.jpg"/></li>
                <li><img src="images/dd_scroll_6.jpg"/></li>
            </ul>
            <ul id="scroll_number">
                <li>1</li>
                <li>2</li>
                <li>3</li>
                <li>4</li>
                <li>5</li>
                <li>6</li>
            </ul>
        </div>
        <div class="scroll_end"></div>
        <!--最新上架开始-->
        <div id="bookTab" class="book_sort">
            <div class="book_new">
                <div class="book_left">最新上架</div>
                <div class="book_type book_type_out" id="history">历史</div>
                <div class="book_type" id="family">家教</div>
                <div class="book_type" id="culture">文化</div>
                <div class="book_type" id="novel">小说</div>
                <div class="book_right"><a href="#">更多&gt;&gt;</a></div>
            </div>
            <div class="book_class" style="height:250px;">
                <!--历史-->
                <dl id="book_history">
                    <c:forEach items="${requestScope.infos}" var="book" begin="0" end="3">
					<dt><img src="${book.bookImage}" alt="history"/></dt>
						<dd>
							<font class="book_title">${book.bookName }</font><br />
							作者：${book.bookAuthor}<br />
							
							<font class="book_publish">出版社：${book.publisher.pubName}</font><br />
               				 定价：￥${book.bookPrice}<br />
               				 当当价：￥${book.realPrice}
                		</dd>
			
			</c:forEach>
                </dl>
                <!--家教-->
                <dl id="book_family" class="book_none">
                    <dt><img src="images/dd_family_1.jpg" alt="history"/></dt>
                    <dd>
                        <font class="book_title">嘿，我知道你</font><br />
                        作者：兰海　著 <br />
                        出版社：中国妇女出版社 <br />
                        <font class="book_publish">出版时间：2009年10月</font><br />
                        定价：￥28.80<br />
                        当当价：￥17.90
                    </dd>
                    <dt><img src="images/dd_family_2.jpg" alt="history"/></dt>
                    <dd>
                        <font class="book_title">择业要趁早</font><br />
                        作者：（美）列文<br />
                        出版社：海天出版社 <br />
                        <font class="book_publish">出版时间：2009年10月</font><br />
                        定价：￥28.00<br />
                        当当价：￥19.30
                    </dd>
                    <dt><img src="images/dd_family_3.jpg" alt="history"/></dt>
                    <dd>
                        <font class="book_title">爷爷奶奶的“孙子兵法”</font><br />
                        作者：伏建全 编著 <br />
                        出版社：地震出版社 <br />
                        <font class="book_publish"> 出版时间：2009年8月</font><br />
                        定价：￥28.00<br />
                        当当价：￥17.40
                    </dd>
                    <dt><img src="images/dd_family_4.jpg" alt="history"/></dt>
                    <dd>
                        <font class="book_title">1分钟读懂孩子心理</font><br />
                        作者：海韵　著 <br />
                        出版社：朝华出版社 <br />
                        <font class="book_publish">出版时间：2009年10月</font><br />
                        定价：￥28.00<br />
                        当当价：￥17.40
                    </dd>
                </dl>
                <!--文化-->
                <dl id="book_culture" class="book_none">
                    <dt><img src="images/dd_culture_1.jpg" alt="history"/></dt>
                    <dd>
                        <font class="book_title">嘿，我知道你</font><br />
                        作者：兰海　著 <br />
                        出版社：中国妇女出版社 <br />
                        <font class="book_publish">出版时间：2009年10月</font><br />
                        定价：￥28.80<br />
                        当当价：￥17.90
                    </dd>
                    <dt><img src="images/dd_culture_2.jpg" alt="history"/></dt>
                    <dd>
                        <font class="book_title">择业要趁早</font><br />
                        作者：（美）列文 <br />
                        出版社：海天出版社 <br />
                        <font class="book_publish">出版时间：2009年10月</font><br />
                        定价：￥28.00<br />
                        当当价：￥19.30
                    </dd>
                    <dt><img src="images/dd_culture_3.jpg" alt="history"/></dt>
                    <dd>
                        <font class="book_title">爷爷奶奶的“孙子兵法”</font><br />
                        作者：伏建全 编著 <br />
                        出版社：地震出版社 <br />
                        <font class="book_publish"> 出版时间：2009年8月</font><br />
                        定价：￥28.00<br />
                        当当价：￥17.40
                    </dd>
                    <dt><img src="images/dd_culture_4.jpg" alt="history"/></dt>
                    <dd>
                        <font class="book_title">1分钟读懂孩子心理</font><br />
                        作者：海韵　著 <br />
                        出版社：朝华出版社 <br />
                        <font class="book_publish">出版时间：2009年10月</font><br />
                        定价：￥28.00<br />
                        当当价：￥17.40
                    </dd>
                </dl>
                <!--小说-->
                <dl id="book_novel" class="book_none">
                    <dt><img src="images/dd_novel_1.jpg" alt="history"/></dt>
                    <dd>
                        <font class="book_title">嘿，我知道你</font><br />
                        作者：兰海　著 <br />
                        出版社：中国妇女出版社 <br />
                        <font class="book_publish">出版时间：2009年10月</font><br />
                        定价：￥28.80<br />
                        当当价：￥17.90
                    </dd>
                    <dt><img src="images/dd_novel_2.jpg" alt="history"/></dt>
                    <dd>
                        <font class="book_title">择业要趁早</font><br />
                        作者：（美）列文 <br />
                        出版社：海天出版社 <br />
                        <font class="book_publish">出版时间：2009年10月</font><br />
                        定价：￥28.00<br />
                        当当价：￥19.30
                    </dd>
                    <dt><img src="images/dd_novel_3.jpg" alt="history"/></dt>
                    <dd>
                        <font class="book_title">爷爷奶奶的“孙子兵法”</font><br />
                        作者：伏建全 编著 <br />
                        出版社：地震出版社 <br />
                        <font class="book_publish"> 出版时间：2009年8月</font><br />
                        定价：￥28.00<br />
                        当当价：￥17.40
                    </dd>
                    <dt><img src="images/dd_novel_4.jpg" alt="history"/></dt>
                    <dd>
                        <font class="book_title">1分钟读懂孩子心理</font><br />
                        作者：海韵　著 <br />
                        出版社：朝华出版社 <br />
                        <font class="book_publish">出版时间：2009年10月</font><br />
                        定价：￥28.00<br />
                        当当价：￥17.40
                    </dd>
                </dl>
            </div>
        </div>
        <!--重点关注-->
        <div class="book_sort">
            <div class="book_new">
                <div class="book_left">重点关注</div>
            </div>
            <div class="book_class" style="height:380px;">
                <dl id="book_focus">
                    <c:forEach items="${requestScope.infosFocus1 }" var="book1" begin="0" end="3">
                    <dt><img src="${book1.bookImage}" alt="focus"/></dt>
                    </c:forEach>
                    
					<c:forEach items="${requestScope.infosFocus1 }" var="book1" begin="0" end="3">
					<dd><a href="#" class="blue">      ${book1.bookName}</a></dd>
					</c:forEach>
					<c:forEach items="${requestScope.infosFocus1 }" var="book1" begin="0" end="3">
					<dd>定价:￥${book1.bookPrice}<br />
					当当价:￥${book1.realPrice}</dd>
					</c:forEach>

					 <c:forEach items="${requestScope.infosFocus2 }" var="book2" begin="0" end="3">
                    <dt><img src="${book2.bookImage}" alt="focus"/></dt>
                    </c:forEach>
                    
					<c:forEach items="${requestScope.infosFocus2 }" var="book2" begin="0" end="3">
					<dd><a href="#" class="blue">${book2.bookName}</a></dd>
					</c:forEach>
					<c:forEach items="${requestScope.infosFocus2 }" var="book2" begin="0" end="3">
					<dd>定价:￥${book2.bookPrice}<br />
					当当价:￥${book2.realPrice}</dd>
					</c:forEach>
                </dl>
            </div>
        </div>
    </div>
    <!--中间部分结束-->
    <!--右侧部分开始-->
    <div id="silder">
        <!--书讯快递-->
        <div class="book_sort">
            <div class="book_sort_bg"><img src="images/dd_book_mess.gif" alt="mess" style=" vertical-align:text-bottom;"/>书讯快递</div>
            <div class="book_class">
                <div id="dome">
                    <div id="dome1">
                        <ul id="express">
                            <li>・2010考研英语大纲到货75折...</li>
                            <li>・权威定本四大名著（人民文...</li>
                            <li>・口述历史权威唐德刚先生国...</li>
                            <li>・袁伟民与体坛风云：实话实...</li>
                            <li>・我们台湾这些年：轰动两岸...</li>
                            <li>・畅销教辅推荐：精品套书50...</li>
                            <li>・2010版法律硕士联考大纲75...</li>
                            <li>・计算机新书畅销书75折抢购</li>
                            <li>・2009年孩子最喜欢的书&gt;&gt;</li>
                            <li>・弗洛伊德作品精选集59折</li>
                            <li>・2010考研英语大纲到货75折...</li>
                            <li>・权威定本四大名著（人民文...</li>
                            <li>・口述历史权威唐德刚先生国...</li>
                            <li>・袁伟民与体坛风云：实话实...</li>
                            <li>・我们台湾这些年：轰动两岸...</li>
                            <li>・畅销教辅推荐：精品套书50...</li>
                            <li>・2010版法律硕士联考大纲75...</li>
                            <li>・计算机新书畅销书75折抢购</li>
                            <li>・2009年孩子最喜欢的书&gt;&gt;</li>
                            <li>・弗洛伊德作品精选集59折</li>
                            <li>・2010考研英语大纲到货75折...</li>
                            <li>・权威定本四大名著（人民文...</li>
                            <li>・口述历史权威唐德刚先生国...</li>
                            <li>・袁伟民与体坛风云：实话实...</li>
                            <li>・我们台湾这些年：轰动两岸...</li>
                            <li>・畅销教辅推荐：精品套书50...</li>
                            <li>・2010版法律硕士联考大纲75...</li>
                            <li>・计算机新书畅销书75折抢购</li>
                            <li>・2009年孩子最喜欢的书&gt;&gt;</li>
                            <li>・弗洛伊德作品精选集59折</li>
                            <li>・2010考研英语大纲到货75折...</li>
                            <li>・权威定本四大名著（人民文...</li>
                            <li>・口述历史权威唐德刚先生国...</li>
                            <li>・袁伟民与体坛风云：实话实...</li>
                            <li>・我们台湾这些年：轰动两岸...</li>
                            <li>・畅销教辅推荐：精品套书50...</li>
                            <li>・2010版法律硕士联考大纲75...</li>
                            <li>・计算机新书畅销书75折抢购</li>
                            <li>・2009年孩子最喜欢的书&gt;&gt;</li>
                            <li>・弗洛伊德作品精选集59折</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="book_express_avder"> <img src="images/dd_book_right_adver1.jpg" alt="adver" style="margin-bottom:5px;" /> <img src="images/dd_book_right_adver2.gif" alt="adver" /> </div>
        </div>
        <!--近7日畅销榜-->
        <div class="book_sort">
            <div class="book_seven_title">近7日畅销榜 <img src="images/dd_bang.gif" alt="bang" style="vertical-align:top;"/></div>
            <div class="book_seven_border">
                <div class="book_seven_top">
                    <ul id="book_seven_cate">
                        <li>动漫</li>
                        <li>小说</li>
                        <li>外语</li>
                        <li>旅游</li>
                        <li>励志</li>
                    </ul>
                </div>
                <div class="book_seven_content">
                    <div class="book_seven_content_left">
                        <dl id="book_seven_number">
                            <dt><img src="images/dd_book_no_01.gif" alt="book"/></dt>
                            <dt><img src="images/dd_book_no_02.gif" alt="book"/></dt>
                            <dt><img src="images/dd_book_no_03.gif" alt="book"/></dt>
                            <dd><img src="images/dd_book_no_04.gif" alt="book"/></dd>
                            <dd><img src="images/dd_book_no_05.gif" alt="book"/></dd>
                            <dd><img src="images/dd_book_no_06.gif" alt="book"/></dd>
                            <dd><img src="images/dd_book_no_07.gif" alt="book"/></dd>
                            <dd><img src="images/dd_book_no_08.gif" alt="book"/></dd>
                        </dl>
                    </div>
                    <div class="book_seven_content_right">
                        <!--励志开始-->
                        <div id="book_seven_hearten">
                            <dl>
                                <dt><img src="images/dd_seven_hearten_01.jpg" alt="hearten" /></dt>
                                <dd>
                                    <a href="#" class="blue">不抱怨的世界</a><br />
                                    作者：（美）鲍温<br />
                                    出版社：陕西师范<br />
                                    出版时间：2009年4月
                                </dd>
                                <dt><img src="images/dd_seven_hearten_02.jpg" alt="hearten" /></dt>
                                <dd>
                                    <a href="#" class="blue">遇见未知的自己</a><br />
                                    作者：张德芬 <br />
                                    出版社：华夏出版<br />
                                    出版时间：2008年1月
                                </dd>
                                <dt><img src="images/dd_seven_hearten_03.jpg" alt="hearten" /></dt>
                                <dd>
                                    <a href="#" class="blue">活法</a><br />
                                    作者：（日）稻盛<br />
                                    出版社：东方出版<br />
                                    出版时间：2005年3月
                                </dd>
                            </dl>
                            <ul>
                                <li><a href="#" class="blue">高效能人士的七个习惯</a></li>
                                <li><a href="#" class="blue">被迫强大</a></li>
                                <li><a href="#" class="blue">遇见心想事成的自己</a></li>
                                <li><a href="#" class="blue">世界上最伟大的推销员</a></li>
                                <li><a href="#" class="blue">我的成功可以复制</a></li>
                            </ul>
                        </div>
                        <!--励志结束-->
                    </div>
                </div>
            </div>
        </div>
    </div>
<!--右侧部分结束-->
</div>
<!--网站版权部分开始-->
<div id="footer">
    <div class="footer_top"><a href="#" target="_parent" class="footer_dull_red">公司简介</a> | <a href="#" target="_parent" class="footer_dull_red">诚证英才</a> | <a href="#" target="_parent" class="footer_dull_red">网站联盟</a> | <a href="#" target="_parent" class="footer_dull_red">百货招商</a> | <a href="#" target="_parent" class="footer_dull_red">交易条款</a></div>
    <iframe src="footer.jsp" height="50px" width="900px" frameborder="0"></iframe>
</div>
</body>
</html>
