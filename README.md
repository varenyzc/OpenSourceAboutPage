# OpenSourceAboutPage

An Android library that makes about-pages building extremely easy.

## 效果图
<p>
  <img src="https://github.com/varenyzc/OpenSourceAboutPage/blob/master/img/img1.jpg?raw=true" width="270" height="540" alt="效果图1" />
  <img src="https://github.com/varenyzc/OpenSourceAboutPage/blob/master/img/img2.jpg?raw=true" width="270" height="540" alt="效果图2"/>
</p>

## 快速使用

### 步骤一：把jitpack添加到根目录的build.gradle中

```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

### 步骤二：在app目录下的build.gradle中添加依赖

```java
dependencies {
	    implementation 'com.github.varenyzc:OpenSourceAboutPage:1.2' 
            implementation 'com.android.support:cardview-v7:last_version'
	}
```

因为我在项目中使用了CardView，所以需要添加cardview的依赖库，这里cardview的版本取决于你的sdk版本。

### 步骤三：在布局文件中引用
```xml
<io.github.varenyzc.opensourceaboutpages.LogoCard
    android:id="@+id/logo"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:appName="@string/app_name"
    app:copyright="©2019 varenyzc"
    app:logoSrc="@drawable/ic_launcher_round">

</io.github.varenyzc.opensourceaboutpages.LogoCard>
<io.github.varenyzc.opensourceaboutpages.MessageCard
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:title="作者"
    android:id="@+id/message">

</io.github.varenyzc.opensourceaboutpages.MessageCard>
```

整个项目有两个自定义view：LogoCard和MessageCard。LogoCard为带logo的view，MessageCard仅有标题。

### 步骤四：在java文件中编写代码

这里以LogoCard为例，MessageCard请看Demo。

#### 首先要初始化LogoCard对象：
```java
 LogoCard logoCard = (LogoCard) findViewById(R.id.logo);
 ```

#### 接着创建Item对象：
项目中包含带描述的item和不带描述的item，这里以带描述item为例。

```java
AboutPageMessageItem item1 = new AboutPageMessageItem(this).
                setIcon(getDrawable(R.drawable.ic_launcher_round)).
                setDescriptionText("1.0").
                setMainText("版本号").
                setOnItemClickListener(new AboutPageMessageItem.AboutPageOnItemClick() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this,"当前版本号1.0",Toast.LENGTH_SHORT).show();
                    }
                });
```

这里采用链式调用，使用方便。除此之外还有其他设置方法，请看下面的详细文档。

#### 在LogoCard中添加item：

```java
logoCard.addMessageItem(item1);
```

LogoCard也是采用链式调用，addMessageItem中可添加无数个item，但不能重复添加，否则会报错。除了addMessageItem之外还有设置上方logo等信息的方法，这里不详细展开，请看下方详细文档。

至此，该项目使用完成。

---
## 详细文档

### LogoCard

#### 属性说明

| 属性        | 说明   |类型   |
| --------   | --------- |--------- |
| logoSrc |logo图片|integer|
| appName |app名字文本|string|
| copyright | 版权文本 | string |
| appNameTextSize | app名字文本大小 | float |
| appNameTextColor | app名字文本颜色 | color |
| copyrightTextSize | 版权文本大小 | float |
| copyrihgtTextColor | 版权文本颜色 | color |

#### 方法说明
```java
setLogo(Drawable drawable)  //设置logo图片
setAppname(String text) //设置app名字文本
setCopyright(String text) //设置版权文本
setAppnameTextSize(float size) //设置app名字文本大小
setAppnameTextColor(int color) //设置app名字文本颜色
setCopyrightTextSize(float size) //设置版权文本大小
setCopyrightTextColor(int color) //设置版权文本颜色
addMessageItem(@NonNull AboutPageMessageItem... items) //添加item，该方法无限参数个数
```

### MessageCard

#### 属性说明

| 属性        | 说明   |类型   |
| --------   | --------- |--------- |
| title | 标题文本 | string |
| titleTextSize  | 标题文本大小 | float |
| titleTextColor | 标题文本颜色 | integer |

#### 方法说明

```java
setTitle(String title)      //设置标题
setTitleTextSize(float titleTextSize)       //设置标题文本大小
setTitleTextColor(int titleTextColor)       //设置标题文本颜色
addMessageItem(AboutPageMessageItem... items)   //添加item，该方法也无限参数个数
```

### AboutPageMessageItem

#### 方法说明
```java
setIcon(Drawable drawable)      //设置左侧icon
setMainText(String text)        //设置上层主要文本
setDescriptionText(String text) //设置下层描述文本
setMainTextSize(float size)     //设置上层主要文本大小
setMainTextColor(int color)     //设置上层主要文本颜色
setDescriptionTextSize(float size)      //设置下层描述文本大小
setDescriptionTextColor(int color)      //设置下层描述文本颜色
setOnItemClickListener(AboutPageOnItemClick aboutPageOnItemClick)       //设置item的点击事件
```

### AboutPageMessageItemWithoutDescription

#### 方法说明
```java
setMessage(String text)     //设置信息文本
setIcon(Drawable drawable)  //设置左侧icon 
setMessageTextSize(float size)  //设置信息文本大小
setMessageTextColor(int color)  //设置信息文本颜色
setOnItemClickListener(AboutPageOnItemClick aboutPageOnItemClick)   //设置item的点击事件
```

----------
如果本库对你有用，欢迎star或者fork! 欢迎访问 [我的博客](https://varenyzc.github.io/) 查看更多文章。