tag：Android自定义View~      tag：Android自定义控件~

- [View的结构](#1.0.0、View的结构)    
- [View绘制流程](#1.0.1、View绘制流程)
    - [树的绘制](#树的绘制)

**本内容只是从概念上进行解释，未深入源码进行探究，部分内容对很多朋友来说熟悉简单，可以省略跳过**

## 1.0.0、View的结构（我是谁）
官方说明   [UI概览](https://developer.android.google.cn/guide/topics/ui/overview.html)  
> Android 应用中的所有用户界面元素都是使用 View 和 ViewGroup 对象构建而成。      

![视图层次结构](https://developer.android.google.cn/images/viewgroup.png)

#### Activity中的View结构

![Activity上面的View绘制结构](http://wx4.sinaimg.cn/mw690/ebd4f4c2gy1fhyq4py2fzj20b10g974n.jpg)


**PhoneView**： 接收系统传递过来的是点击事件，io操作，然后回调给Activity，这里暂时不进入深入研究。

**DecorView**： 包含Title标题布局和Content内容布局，根据主题进行加载操作显示 TitleView 和 ContentView ，一般我们调用 `.setContentView()` 就是将布局添加到 ContentView 中的。




![Android常用View](http://upload-images.jianshu.io/upload_images/749674-f7d5d018d05bad46.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

#### 小结
- Android 的主要视图是由View和ViewGroup组成，ViewGroup继承自View，作为一个容器类（LinearLayout、RelativeLayout、FrameLayout等等），不仅可以包含View，也可以包含ViewGroup。
- 每一个用户界面都是由ViewGroup和View以树的结构形式构建起来，而且根节点必须为ViewGroup。

## 1.0.1、View绘制流程
- #### 树的绘制
    从上面的描述我们可以知道View是以树状的结构进行数据的组织，所以在这个过程中View的计算和绘制，都是由根节点*ViewRoot*调用`performTraversals()`发起，自上而下触发对下一级子View对自身的绘制，直至到最底层view完成对自身的绘制,然后将计算结果返回上一层进行绘制。
![View树的绘制，图片来自《公共技术点之 View 绘制流程》，作者：lightSky](https://raw.githubusercontent.com/android-cn/android-open-project-analysis/master/tech/viewdrawflow/image/measure_layout.png)


- #### 子View绘制
  - 位置参数 [Size, padding and margins](https://developer.android.google.cn/reference/android/view/View.html#SizePaddingMargins)    
size 是描述view的宽和高，实际是有两对参数一个
  - 


