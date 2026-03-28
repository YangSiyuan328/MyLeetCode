# 1115. 交替打印 FooBar

<table>
<tr><td><b>难度</b></td><td>Medium</td></tr>
<tr><td><b>标签</b></td><td>多线程</td></tr>
<tr><td><b>会员</b></td><td>否</td></tr>
<tr><td><b>链接</b></td><td><a href="https://leetcode.cn/problems/print-foobar-alternately/description/">在线练习</a></td></tr>
</table>

## 题目描述

给你一个类：
class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }
  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
两个不同的线程将会共用一个 `FooBar` 实例：
  * 线程 A 将会调用 `foo()` 方法，而
  * 线程 B 将会调用 `bar()` 方法
请设计修改程序，以确保 `"foobar"` 被输出 `n` 次。

**示例 1：**

**输入：** n = 1

**输出：** "foobar"

**解释：** 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。

**示例 2：**

**输入：** n = 2

**输出：** "foobarfoobar"

**解释：** "foobar" 将被输出两次。

**提示：**
  * `1 <= n <= 1000`

## 示例

```
1
2
```

## 参考答案

```java
class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
        }
    }
}
```

## 一刷思路

```java
class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
        }
    }
}
```

## 二刷思路

```java
class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
        }
    }
}
```
