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












