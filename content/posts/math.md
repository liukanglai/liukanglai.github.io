---
title: "Math"
date: 2023-03-25T21:03:31+08:00
draft: true
tags: ["first"]
author: "liukanglai"
description: " "
---

## 组合

- 广义的组合数学（英语：Combinatorics）就是离散数学，狭义的组合数学是组合计数、图论、代数结构、数理逻辑等的总称。

### 错排问题

- $D_n$=n$D_{n-1}$ + $(-1)^{n}$。

1. 枚举法

   - n 从一开始: 0, 1, 2, 9, 44, 265, 1854, 14833, 133496, 1334961, 14684570, 176214841, 2290792932, ...

2. 递推数列法

   - 对于排列数较多的情况，难以采用枚举法。这时可以用递归思想推导错排数的递回关系式。

     显然 D1=0，D2=1。当 n≥3 时，不妨设 n 排在了第 k 位，其中 k≠n，也就是 1≤k≤n-1。那么我们现在考虑 k 的情况。

     当 k 排在第 n 位时，除了 n 和 k 以外还有 n-2 个数，其错排数为 Dn-2。

     当 k 不排在第 n 位时，那么将第 n 位重新考虑成一个新的“第 k 位”，这时的包括 k 在内的剩下 n-1 个数的每一种错排，都等价于只有 n-1 个数时的错排（只是其中的第 k 位会换成第 n 位）。其错排数为 Dn-1。

     所以当 n 排在第 k 位时共有 Dn-2+Dn-1 种错排方法，又 k 有从 1 到 n-1 共 n-1 种取法，我们可以得到：

     $D_n$=(n-1)($D_{n-1}$ + $D_{n-2}$)

## 数论

- x^a \* x^b = x^(a+b)
- x^a / x^b = x^(a-b)
- (x^a)^b = x^(a\*b)
- x^n + x^n = 2x^n != x^(2n)
- 2^n + 2^n = 2^(n+1)

## 线性代数

### 方程组的几何解释

- row：相交
- column：向量变换

> 线性变换！！！ matrix &times; colum （列组合） row &times; matrix （行组合） --> matrix &times; matrix (...)

### 矩阵消元

- 回代
- 主元 （$E_{21}$，means 将 2，1 的元素置 0 的矩阵)
- $E_{21}$ ($E_{32}$ &times; A) = ($E_{21}$ &times; $E_{32}$) A
- 行变换左乘，列变换右乘

### 矩阵运算

### 乘法 A &time; B = C

1. 常规：A 行 B 列 = 元素
2. A 对 B 的行线性组合
3. B 对 A 的列线性组合
4. A 每列 &times B 每行 相加

5. block

### rank

- matrix: rank 1 + rank 1 may be rank 2

### Inverse

- 逆 Inverses 将原矩阵变为单位矩阵 I --导数
- 对于方阵：左逆 = 右逆
- 非方阵的逆：求不出来。。。

- 可逆的，非奇异的

- 不可逆的，奇异的

  - 行列式为 0
  - 与非 0 矩阵乘会 = 0

#### 求解

1. Gauss-Jordan
   - 将 A 变为 I，then I 变为 $A^{-1}$

> E vs I ???

#### A = LU = LDU

- 方阵, 可逆, no 0 主元(无行交换)

- U --upper triangular m &times; n
- L --lower triangular m &times; m
- D --diagonal
- change U to DU

- EA = U -> A = LU, no row exchanges, 消元系数会直接在 L 中

> Ax = b; use Gauss is too difficulty, so solve LUx = b; Ux = y, Ly = b;
>
> find L: U -> A, then I -> L

### 运算律

- 结合律

### permutation

- 置换（permutation）矩阵 P 是方阵，进行行排列， P 的每一行和每一列都有且仅有一个 1，其余均为 0
- I 基本置换矩阵
- n &times; n 的 P 矩阵有 n! 个，P 矩阵是将 P 的行重排列

#### 属性

- P 矩阵的乘积都是 P 矩阵，行重新排列
- P 矩阵都是可逆矩阵，$P^{-1}$ = $P^{T}$, P$P^{T}$ = I

- PA = LU, P 进行行交换，消除 0 主元

### symmetric

- A = $A^T$
- $(R R^T) ^ T$ = ...

### 向量空间

- 对加法，乘法封闭

#### 子空间

- R^2 的子空间：自己，过原点的直线，0 点（0 向量空间）
- 子空间相交，仍是子空间

- 构造：取列，行，进行线性组合

#### 列空间 C(A) -- Ax = b 有解的所有 b（对 A 的 列线性组合）

- in R^m
- dim: r
- 基：主元所在列

> 行变换后，列空间变化，行空间不变

#### 0 空间 N(A)（不是 0 向量空间）

- Ax = 0 的所有 x，不仅限于 0！！！
- in R^n
- dim: n - r
- 基：free 所在列, 特解

#### 行空间 R(A) C($A^T$)

- in R^n
- dim:r
- 基：主元所在行

#### N($A^T$) 左 0 空间

- in R^m
- dim: m - r
- 基：[A I] -> [R E], EA = R, find E, R 中有 0 行，则其对应 E 即是基，(此基对 A 做行组合得到 0)
- 对 A 行排列得 0

### 矩阵空间 3 &times; 3 matrix

> R^n 空间 -> R^(n\*n)
>
> 类似 9 维空间

- upper; dim: 6
- symmetric; dim: 6
- diagonal; dim: 3

> dim(S + U) = dim(S &bigcap; U + S and U);

#### $d^2$y/d$x^2$ +y = 0

- y = c1cosx + c2sinx
- basis: cosx, sinx or e^{ix}, e^{-ix}
- dim: 2

#### r1 + r2 + r3 + r4 = 0

- v = [r1, r2, r3, r4]^T
- Av = 0, A = [1, 1, 1, 1]
- C(A) = R(A) = 1 N(A) = 3

- dimv: 3

### 方程

#### Ax = 0

1. elimination -> Ux = 0
2. find pivot and free columns(the sum is n-r)
3. use free variables(列向量无主元) to complete the other variables, 赋特殊值(0, 1...)
4. all the combinations of the special solutions

- $x_n$ = c1[] + c2[] + ...

> 使用简化行阶梯矩阵，并换列，可得：

$$
\left[
 \begin{matrix}
   I & F\\
   0 & 0
  \end{matrix}
\right]
$$

> 则特解为

$$
\left[
 \begin{matrix}
    -F\\
    I
  \end{matrix}
\right]
$$

#### 简化行阶梯矩阵 R

- 主元上下为 0，主元为 1

#### Ax = b

> 有解：b 必须是 A 的列空间

- augmented matrix

1. set free variables to 0, then solve the privot variables, get $x_p$
2. add the 0 空间解($x_n$): $x_p$ + $x_n$

> A$x_p$ = b, a$x_n$ = 0, then A($x_p$ + $x_n$) = b.

# r <=n & r <= m

1. r = n

   - R =
   - $x_n$ = 0
   - $x_p$ 解唯一，0 或 1 个

2. r = m

   - R = [I F]
   - 每个 b 都有解
   - free variables are n-m

3. r = m = n
   - R = I
   - $x_n$ = 0
   - 每个 b 都有解, $x_p$ 只有一个

### 向量组

## 线性相关/无关

1. 无关
   - 组合无 0
   - c1x1 + c2x2 + ... + cnxn != 0 (except all c is 0) // Ax = 0, only x = 0，则 A 的列向量无关

## basis

- 向量组：无关 + 生成一个空间（维度必须最大，即生成所有的向量组合）
- 对于方阵，必须可逆 --向量组是基，那么它一定是方阵

> 矩阵的基不同于向量组的基！

## dimension

- 向量组生成空间：所有的线性组合
- 维度即基的个数，即单个向量的位数，而矩阵则是其无关向量组
- 对于矩阵，列空间维度是 rank，即主列的个数

- 矩阵：秩
- 空间：维度

- 列空间的维度：rank
- 0 空间的维度：free pivot = n - r

## graph

small world, to find the relationship

- Graph = {nodes, edges}

## 高数

### 特殊值求解法

### 求极值

- 同步趋近
- 洛必达法则->针对求导简单
- 等价无穷小要在趋近的时候用

### 重积分

1. 二重积分的概念

2. 二重积分的计算

3. 三重积分

   - 概念和性质
   - 区域可加，被积函数可加
   - 对称？？？
   - 直角坐标系

> 先一后二，先二后一

- 柱面坐标系
  (&rho;,&theta;,z)
  先 Z,r
  与圆相关,x^2+y^2
  f\*r

- 球面坐标系

(r,&theta;,zom)
r>=0,0-2&pi;,0-&pi;
x=rsin&phi;cos&theta;
y=rsin&phi;sin&theta;
z=rcos&phi;
&rho;=rsin&phi;
z=rcos&phi;

> 边界小于等于 2 点，大分割

4. 重积分的应用

   - 体积
   - 面积
   - 质心
   - 转动惯量
   - 引力

### 曲线积分和曲面积分

1. 对弧长的曲线积分-第一类曲线积分

   - 定义
   - 计算
   - 可代性

2. 对坐标的曲线积分-第二类曲线积分

   - 概念
   - 计算

> 两类曲线积分的关系

3. 格林公式

> 连通区域(单,复)
>
> 方向

### 级数

1. 常数项

2. 常数项级数的审判法

   - 正
   - 交错
   - 任意

3. 幂级数

   - 函数展开的条件
   - Abel
   - 运算

4. 泰勒级数

   - 常见

5. 傅里叶级数/三角级数

   - f(x)=a0/2+
   - 三角函数系

     > 正交
     > (-π,π) 不同相乘积分为 0,同为 π(1 除外)

   - 求 a0 积分

     > an 乘 cosnx 积分
     > bn sinnx
     > 傅里叶系数

   - 展开的充分条件 狄利克雷充分条件

     > 收敛性

   - 正弦,余弦级数

     > 奇
     > 偶

   - 非周期函数 延拓

     > 到 2π
     > f(x+2π)=f(x)
     > 奇延拓 偶延拓

---
