# CircularRevealLayout
兼容5.0以下圆形揭示效果

![Image](https://github.com/huweijian5/CircularRevealLayout/blob/master/screenshots/QQ%E6%88%AA%E5%9B%BE20161213224059.png)
***
![Image](https://github.com/huweijian5/CircularRevealLayout/blob/master/screenshots/device-2016-12-13-223904.mp4_1481640644.gif)

##使用说明
* 在想要圆形揭示的布局上添加父布局CircularRevealLayout
```
<com.junmeng.crl.CircularRevealLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <RelativeLayout
                android:id="@+id/rl_img"
                android:layout_width="match_parent"
                android:layout_height="match_parent">

                <ImageView
                    android:id="@+id/iv_img"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:src="@mipmap/ic_launcher" />

                <Button
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:onClick="onClickStart"
                    android:text="兼容5.0以下圆形揭示效果" />
            </RelativeLayout>

        </com.junmeng.crl.CircularRevealLayout>
```
* 然后使用ViewAnimationCompatUtils与android原生的ViewAnimationUtils一样的接口则可兼容5.0以下的圆形揭示效果
```
 ViewAnimationCompatUtils.createCircularReveal(
                binding.rlImg,
                binding.rlImg.getWidth()/2,
                binding.rlImg.getHeight()/2,
                0,1000
        ).setDuration(1000).start();
```
## 引用

* 如果需要引用此库,做法如下：
* Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```	
* and then,add the dependecy:
```
dependencies {
	        compile 'com.github.huweijian5:CircularRevealLayout:latest_version'
}
```
* 其中latest_version请到[releases](https://github.com/huweijian5/CircularRevealLayout/releases)中查看
