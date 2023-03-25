---
title: ""
draft: false
tags: ["first"]
author: "liukanglai"
# author: ["Me", "You"] # multiple authors
showToc: true
TocOpen: false
hidemeta: false
comments: false
description: "Desc Text."
canonicalURL: "https://canonical.url/to/page"
disableHLJS: true # to disable highlightjs
disableShare: false
disableHLJS: false
hideSummary: false
searchHidden: true
ShowReadingTime: true
ShowBreadCrumbs: true
ShowPostNavLinks: true
ShowWordCount: true
ShowRssButtonInSectionTermList: true
UseHugoToc: true
cover:
    image: "<image path/url>" # image path/url
    alt: "<alt text>" # alt text
    caption: "<text>" # display caption under cover
    relative: false # when using page bundles set this to true
    hidden: true # only hide on current single page
editPost:
    URL: "https://github.com/<path_to_repo>/content"
    Text: "Suggest Changes" # edit text
    appendFilePath: true # to append file path to Edit link
---# 方程组的几何解释

- row：相交
- column：向量变换

> 线性变换！！！ matrix &times; colum （列组合）  row &times; matrix （行组合） -->  matrix &times; matrix (...)

# 矩阵消元

- 回代
- 主元 （$E_{21}$，means 将2，1的元素置0的矩阵)
- $E_{21}$ ($E_{32}$ &times; A) = ($E_{21}$ &times; $E_{32}$) A
- 行变换左乘，列变换右乘

# 矩阵运算

## 乘法 A &time; B = C

1. 常规：A行 B列 = 元素
2. A 对 B 的行线性组合
3. B 对 A 的列线性组合
4. A每列 &times B每行 相加

5. block 

# rank
- matrix: rank 1 + rank 1 may be rank 2

## Inverse

- 逆 Inverses 将原矩阵变为单位矩阵 I --导数
- 对于方阵：左逆 = 右逆
- 非方阵的逆：求不出来。。。

- 可逆的，非奇异的

- 不可逆的，奇异的

    - 行列式为 0
    - 与非 0 矩阵乘会 = 0

### 求解

1. Gauss-Jordan
    - 将 A 变为 I，then I 变为 $A^{-1}$

> E vs I ???

### A = LU = LDU

- 方阵, 可逆, no 0 主元(无行交换)

- U --upper triangular  m &times; n
- L --lower triangular  m &times; m 
- D --diagonal
- change U to DU

- EA = U -> A = LU, no row exchanges, 消元系数会直接在L中

> Ax = b; use Gauss is too difficulty, so solve LUx = b; Ux = y, Ly = b;
>
> find L: U -> A, then I -> L

# 运算律

- 结合律

# permutation 

- 置换（permutation）矩阵 P 是方阵，进行行排列， P 的每一行和每一列都有且仅有一个1，其余均为0
- I 基本置换矩阵
- n &times; n 的 P 矩阵有 n! 个，P 矩阵是将 P 的行重排列

## 属性

- P 矩阵的乘积都是 P 矩阵，行重新排列
- P 矩阵都是可逆矩阵，$P^{-1}$ = $P^{T}$, P$P^{T}$ = I


- PA = LU, P 进行行交换，消除 0 主元

# symmetric

- A = $A^T$
- $(R R^T) ^ T$ = ...


# 向量空间

- 对加法，乘法封闭

## 子空间

- R^2 的子空间：自己，过原点的直线，0点（0 向量空间）
- 子空间相交，仍是子空间

- 构造：取列，行，进行线性组合

### 列空间C(A)  -- Ax = b 有解的所有 b（对 A 的 列线性组合）

- in R^m
- dim: r
- 基：主元所在列

> 行变换后，列空间变化，行空间不变

### 0 空间N(A)（不是 0 向量空间）  -- Ax = 0 的所有 x，不仅限于 0！！！

- in R^n
- dim: n - r
- 基：free所在列, 特解

### 行空间R(A) C($A^T$)

- in R^n
- dim:r
- 基：主元所在行

### N($A^T$) 左 0 空间

- in R^m
- dim: m - r
- 基：[A I] -> [R E], EA = R, find E, R 中有 0 行，则其对应 E 即是基，(此基对 A 做行组合得到 0)
- 对 A 行排列得 0

# 矩阵空间 3 &times; 3 matrix

> R^n 空间 -> R^(n*n)
>
> 类似 9 维空间

- upper; dim: 6
- symmetric; dim: 6
- diagonal; dim: 3

> dim(S + U) = dim(S &bigcap; U + S and U);


# $d^2$y/d$x^2$ +y = 0  

- y = c1cosx + c2sinx
- basis: cosx, sinx or e^{ix}, e^{-ix}
- dim: 2

# r1 + r2 + r3 + r4 = 0

- v = [r1, r2, r3, r4]^T
- Av = 0, A = [1, 1, 1, 1]
- C(A) = R(A) = 1 N(A) = 3

- dimv: 3

# 方程

## Ax = 0

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

### 简化行阶梯矩阵 R
- 主元上下为 0，主元为 1

## Ax = b

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



# 向量组 

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
- 对于矩阵，列空间维度是rank，即主列的个数

- 矩阵：秩
- 空间：维度

- 列空间的维度：rank
- 0 空间的维度：free pivot = n - r 


# graph
small world, to find the relationship

- Graph = {nodes, edges}

