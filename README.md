# LinearPagerSnapHelper

![1_-x4xDux_x3tCKG-ryCl7_Q](https://user-images.githubusercontent.com/8086112/162232824-494d1115-75ae-48cc-8568-245c58d07013.gif)


### LinearSnapHelper 와 PagerSnapHelper를 섞은 버전

#### as is
-LinearSnapHelper는 Fling시 스크롤이 너무 많이 된다.
-PagerSnapHelper는 스크롤이 안된다. 페이징만 된다.

#### to be
이 둘을 섞어 드래깅 속도가 일정값 이하일때는 PagerSnapHelper처럼 동작하고, 이상일때는 LinearSnapHelper처럼 동작하는 LinearPagerSnalpHelper를 만들었다.

#### 추가 기능.
- Fling시 스크롤양을 조절할 수 있다.
- Fling 인식 민감도를 조절할 수 있다.
- Settling gravity 옵션이 제공된다.

[Source File Link](https://github.com/Yuseon-Han/hallyu/blob/main/mylibrary/src/main/java/com/yuseon/mylibrary/view/util/LinearPagerSnapHelper.kt)
