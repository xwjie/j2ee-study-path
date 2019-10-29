# 精通css

## css选择器

### 伪元素

::开头的，如 ::first-letter, ::first-line

### 伪类

:开头的

- A标签的
- :target
- :not

### 结构化伪类

与文档结构有关的新伪类。如 :nth-child(odd), :nth-child(3), :nth-child(3n+4), :nth-lash-child, :nth-lash-of-type

### 表单伪类

- :required
- :optional
- :valid
- :in-range, :out-of-range
- :read-only
- :read-write

## link和@import指令

## async和defer

- async：会异步加载脚本，不阻塞HTML解析，但会在脚本加载完毕执行时阻断html解析
- defer：异步加载脚本，不同的是会在html解析完毕之后在执行加载的脚本。



## 可见格式化模型

### 盒子模型

- 修改box-sizing属性可以改变计算盒子大小的方式。
  - 默认值是content-box
  - border-box，width指的是可见的部分，不包括margin

### 可见格式化模型

- 块级盒子(block box)
- 行内盒子(inline box)
- 行盒子(line box)，一行文本形成的水平盒子。修改行盒子的唯一方式就是line-height。
- 匿名块盒子(anonymous block box)
- 匿名行盒子(anonymous line box)

### 外边距折叠

垂直方向外边距相遇，同级关系也可以是父子包含关系

### 相对定位



relative，该元素依然会呆在原来的地方。通过设置top，right，bottom和left 平移元素。

### 绝对定位

会脱离文档流，所以是相对距离他最近的定位祖先，就是display为static之外的任意值的祖先元素。

position 默认值：static

### 浮动

事实上，浮动就是为了在网页上实现文本环绕图片的效果而引入的一种布局模型。

要阻止行盒子环绕在浮动盒子外边，就需要应用clear属性。clear塑性有left，right，both，none，用于指定盒子的哪一边不应该紧挨着浮动盒子。

实际上是给元素增加外边距，从而将元素的上沿垂直下移到浮动元素下方。所以给已经清除浮动的元素加外边距可能无效，需要超过自动加的值才能看到效果。

### 格式化上下文(formating context)

https://www.cnblogs.com/elcarim5efil/p/4745796.html

#### BFC

块格式化上下文（Block Formatting Context，BFC） 是Web页面的可视化CSS渲染的一部分，是块盒子的布局过程发生的区域，也是浮动元素与其他元素交互的区域。

下列方式会创建块格式化上下文：

- 根元素(<html>)
- 浮动元素（元素的 float 不是 none）
- 绝对定位元素（元素的 position 为 absolute 或 fixed）
- 行内块元素（元素的 display 为 inline-block）
- 表格单元格（元素的 display为 table-cell，HTML表格单元格默认为该值）
- 表格标题（元素的 display 为 table-caption，HTML表格标题默认为该值）
- 匿名表格单元格元素（元素的 display为 table、table-row、 table-row-group、table-header-group、table-footer-group（分别是HTML table、row、tbody、thead、tfoot的默认属性）或 inline-table）
- overflow 值不为 visible 的块元素
- display 值为 flow-root 的元素
- contain 值为 layout、content或 paint 的元素
- 弹性元素（display为 flex 或 inline-flex元素的直接子元素）
- 网格元素（display为 grid 或 inline-grid 元素的直接子元素）
-  多列容器（元素的 column-count 或 column-width 不为 auto，包括 column-count 为 1）
- column-span 为 all 的元素始终会创建一个新的BFC，即使该元素没有包裹在一个多列容器中（标准变更，Chrome bug）。

块格式化上下文包含创建它的元素内部的所有内容.

块格式化上下文对浮动定位（参见 float）与清除浮动（参见 clear）都很重要。浮动定位和清除浮动时只会应用于同一个BFC内的元素。浮动不会影响其它BFC中元素的布局，而清除浮动只能清除同一BFC中在它前面的元素的浮动。外边距折叠（Margin collapsing）也只会发生在属于同一BFC的块级元素之间。

但其中，最常见的就是 overflow:hidden/auto 、float:left/right 、position:absolute 。也就是说，每次看到这些属性的时候，就代表了该元素以及创建了一个BFC了。

块级上下文会自动包含浮动。就不需要清除浮动了。


## 漂亮的盒子

### 颜色值和不透明度

- rgb/rgba
- hsl/hsla



## 内容布局

### 定位

- static：块级元素垂直堆叠
- relative：不脱离
- absolute：脱离文档流
- fixed：定位上下文为浏览器视口。

### 三角形

0大小元素，设置边框效果达到。

### z-index 、 重叠上下文

https://developer.mozilla.org/zh-CN/docs/Web/Guide/CSS/Understanding_z_index/The_stacking_context

文档中的层叠上下文由满足以下任意一个条件的元素形成：

- 根元素 (HTML),
- z-index 值不为 "auto"的 绝对/相对定位，
- 一个 z-index 值不为 "auto"的 flex 项目 (flex item)，即：父元素 display: flex|inline-flex，
- opacity 属性值小于 1 的元素（参考 the specification for opacity），
- transform 属性值不为 "none"的元素，
- mix-blend-mode 属性值不为 "normal"的元素，
- filter值不为“none”的元素，
- perspective值不为“none”的元素，
- isolation 属性被设置为 "isolate"的元素，
- position: fixed
- 在 will-change 中指定了任意 CSS 属性，即便你没有直接指定这些属性的值（参考 这篇文章）
- -webkit-overflow-scrolling 属性被设置 "touch"的元素

在层叠上下文中，其子元素同样也按照上面解释的规则进行层叠。 特别值得一提的是，其子元素的 z-index 值只在父级层叠上下文中有意义。子级层叠上下文被自动视为父级层叠上下文的一个独立单元。

### 行内块布局

#### 垂直对齐

利用行内块创建水平布局，如果要垂直对齐，2个要点

1. 要让行内块沿上方对齐，设置vertical-align：top；
2. 要让2个元素的内容垂直对齐，先把他们都转换成行内块，再对他们应用 vertical-align：middle

```html
    <style>
        .author,
        .info {

            /* 行内块垂直对齐 */
            vertical-align: middle;
            /* 让这2个元素在一行内显示 */
            display: inline-block;
        }

        .name,
        .email {
            /* 2行 */
            display: block;
        }
    </style>

    <p class="meta">
        <img src="avatar.png" alt="" class="author">
        <span class="info">
            <span class="name">
                晓风轻
            </span>
            <a href="mailto:121509092@qq.com" class="email">121509092@qq.com</a>
        </span>
    </p>
```

参见：demo.html#demo1

#### 在容器中垂直居中

为了实现容器垂直对齐，需要增加一个行内元素，占据100%高度，设置middle。

```html
        <style>
        /* 垂直居中 */
        .meta2 {
            height: 20em;
            border: 1px solid red;
        }

        .meta2:before {
            content: '';
            display: inline-block;
            vertical-align: middle;
            height: 100%;
            width: 10px;
            background: yellow;
        }

        .author2,
        .info2 {
            /* 行内块垂直对齐 */
            vertical-align: middle;
            /* 让这2个元素在一行内显示 */
            display: inline-block;
        }

        .name2,
        .email2 {
            /* 2行 */
            display: block;
        }
    </style>

    <p class="meta2">
        <img src="avatar.png" alt="" class="author2">
        <span class="info2">
            <span class="name2">
                晓风轻
            </span>
            <a href="mailto:121509092@qq.com" class="email2">121509092@qq.com</a>
        </span>
    </p>
```

#### 追究细节：与空白斗争到底

html源代码中换行符被渲染成了空白符，如果每一个元素25%，就会导致换行。

解决办法

- 把元素都放到一行，不换行。
- 把包含元素的font-size设置为0（从而让空格的宽度为0）

### 使用表格显示属性实现布局



```css
.navbar ul{
    display: table;
    table-layout: fixed;   
}

.navbar li{
    width: 25%;
    display: table-cell;
}

```

见 [demo.html](/css/demo.html)

#### 表格单元中的垂直居中

给table-cell中的元素应用 vertical-align: middle 即可。

## Flexbox

> 关键点：学会 margin：auto 的作用。

### 方向：主轴（水平）和副轴（垂直）

### 嵌套的Flexbox布局

使用margin auto自动计算空间。

还使用了 order：-1调整元素显示顺序。

左右2个div元素高度会自动撑起来，所以他们高度相等。给子容器增加flex属性，让最后一个元素margin-top：auto即可。这样左右2个子容器的元素就会左右对称起来。见 [flex.html](/css/flex.html)


## 二维/三维变换

tranform

## 过渡

transition

## css动画

animation

## css shapes

shape-outside 只能作用给浮动元素，环形环绕等。

[mdn](https://developer.mozilla.org/zh-CN/docs/Web/CSS/shape-outside)

```css
/* 关键字值 */
shape-outside: none;
shape-outside: margin-box;
shape-outside: content-box;
shape-outside: border-box;
shape-outside: padding-box;

/* 函数值 */
shape-outside: circle();
shape-outside: ellipse();
shape-outside: inset(10px 10px 10px 10px);
shape-outside: polygon(10px 10px, 20px 20px, 30px 30px);

/* <url> 值 */
shape-outside: url(image.png);

/* 渐变值 */
shape-outside: linear-gradient(45deg, rgba(255, 255, 255, 0) 150px, red 150px);

/* 全局值 */
shape-outside: initial;
shape-outside: inherit;
shape-outside: unset;
```

- [shape-outside实现文字环绕图片圆弧形排列效果](https://blog.csdn.net/qq_32584661/article/details/80048175)
- [借助CSS Shapes实现元素滚动自动环绕iPhone X的刘海](https://www.zhangxinxu.com/wordpress/2017/09/css-shapes-outside-iphone-x-head/)


```css
shape-outside: circle();
shape-margin: 1em;
```

## 剪切 clip-path 

clip-path CSS 属性可以创建一个只有元素的部分区域可以显示的剪切区域。区域内的部分显示，区域外的隐藏。剪切区域是被引用内嵌的URL定义的路径或者外部svg的路径，或者作为一个形状例如circle().。clip-path属性代替了现在已经弃用的剪切 clip属性。

各种形状的图片。[聊聊clip-path](https://blog.csdn.net/Jizhen_Tan/article/details/52496400)

[mdn](https://developer.mozilla.org/zh-CN/docs/Web/CSS/clip-path)


## 蒙版 mask-image

mask-image, mask-size

## 滤镜

filter


## 浏览器如何解析css

> 学会chrome性能工具使用，理解那些会引起 回流与重绘（Reflow & Repaint）

- [浏览器如何解析css](https://zhuanlan.zhihu.com/p/61015908)
- [浏览器css解析的两种模式](https://www.cnblogs.com/danranysy/p/4744760.html)
- [浏览器渲染原理|绘制|展现|解析|如何工作 - bambooleaf - CSDN博客](https://blog.csdn.net/goodzyw/article/details/46550447)
- [如何减少HTML页面回流与重绘（Reflow & Repaint）](https://zhuanlan.zhihu.com/p/22181897) [前端性能优化：细说浏览器渲染的重排与重绘](https://www.imooc.com/article/45936)
- [使用CSS3 will-change提高页面滚动、动画等渲染性能](https://www.zhangxinxu.com/wordpress/2015/11/css3-will-change-improve-paint/)


## nightwatch 进行 E2E(end to end)测试

Nightwatch.js 是一个用来测试web应用和网站的自动化测试框架，它是由NodeJs编写的，使用了W3C WebDriver API(之前是Selenium WebDriver)

它是完全的浏览器(end-to-end)测试方案，旨在简化搭建持续集成和编写自动话测试的过程。它也同样可以用来写NodeJs的单元测试。

https://blog.csdn.net/qq_25324335/article/details/81990022

- 京东使用 [京东 PC 首页 2019 改版前端总结](https://juejin.im/post/5d71c98a6fb9a06ae8362f52)

## 骨架屏

https://juejin.im/post/5b79a2786fb9a01a18267362

- 手写HTML、CSS的方式为目标页定制骨架屏
  
做法可以参考<Vue页面骨架屏注入实践>，主要思路就是使用 vue-server-renderer 这个本来用于服务端渲染的插件，用来把我们写的.vue文件处理为HTML，插入到页面模板的挂载点中，完成骨架屏的注入。这种方式不甚文明，如果页面样式改变了，还得改一遍骨架屏，增加了维护成本。
骨架屏的样式实现参考 CodePen

- 使用图片作为骨架屏；
  
简单暴力，让UI同学花点功夫吧哈哈；小米商城的移动端页面采用的就是这个方法，它是使用了一个Base64的图片来作为骨架屏。

- 自动生成并自动插入静态骨架屏
  
这种方法跟第一种方法类似，不过是自动生成骨架屏，可以关注下饿了么开源的插件 page-skeleton-webpack-plugin ，它根据项目中不同的路由页面生成相应的骨架屏页面，并将骨架屏页面通过 webpack 打包到对应的静态路由页面中，不过要注意的是这个插件目前只支持history方式的路由，不支持hash方式，且目前只支持首页的骨架屏，并没有组件级的局部骨架屏实现，作者说以后会有计划实现(issue9)。

## requestAnimationFrame + DocumentFragment

https://newbyvector.github.io/2018/05/01/2015-05-01/

[「前端进阶」高性能渲染十万条数据(时间分片)](https://juejin.im/post/5d76f469f265da039a28aff7)

与setTimeout相比，requestAnimationFrame 最大的优势是**由系统来决定回调函数的执行时机**。

如果屏幕刷新率是60Hz,那么回调函数就每16.7ms被执行一次，如果刷新率是75Hz，那么这个时间间隔就变成了1000/75=13.3ms，换句话说就是，requestAnimationFrame的步伐跟着系统的刷新步伐走。它能保证回调函数在屏幕每一次的刷新间隔中只被执行一次，这样就**不会引起丢帧现象**。

