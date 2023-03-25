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
---#

- 行为级模型：主要用于test bench，着重系统行为和算法，不在于电路实现，不可综合（initial，fork/join，task，function，repeat，wait，event，while等）。

- RTL级模型：主要用于ASIC和FPGA设计，重点在于电路实现，在于如何在timing，area和power中做出平衡。可综合出门级电路。（module，always，case，assign等）。

- 门级模型：主要用于后端的物理实现，它是实际电路的逻辑实现，通常由RTL级模型综合出来的，（逻辑门，UDP，线网等），门级模型还用于开发小规模的元件。

        module add
        (
          input  a;
          input  b;
          output c;
        );
          assign c = a&b;
        endmodule




# module
- module -- endmodule
- module layer high use low, only a top module
- parallel run
- testbench

        module G(A, B, C);

            // 参数assignment , 端口: input/output/inout
            input A, B;
            output C;

            // data type, : register, memory, net
            reg R;
            write W;

            // logical, can use function, task, include initial, always...
            and G1(C, A, B);
            assign C = A & B;
        endmodule

> 三位二进制加法器
    
        module adder(cout, sum, a, b, cin);
        // declaration
            intput[2:0] a, b; // three bits
            input cin;
            output cout;
            output[2:0] sum;

            assign{cout, sum} = a + b + cin;
            mytri tri_inst(cout, a, b)
        endmodule

        module mytri(cout, a, b);
            intput[2:0] a, b; // three bits
            output cin;
        endmodule

# grammar/syntax

- ; end
- // or /*..*/
- identifier: letter+number+$+\_, the first one must be letter or \_, have capital and small letter
- parameter(define): parameter a = 100;

# variables

## constant
- 在整型或实数型常量的任何位置可以随意插入下划线符号“_”(但不能作为首字符)，它们就数的本身来说没有意义，但当数很长时，使用下划线更易读
- 基数格式，通常是无符号数，这种形式的格式为 位宽, '进制, 数字, 4'b1001(定长), 'b1(不定长)
- float: 10e2
- string: ""

## variables(net and register)

### net (无符号数)
...
- write
- tri

### register

- reg(无符号数)
- integer(int)
- time(无符号数)
- real/realtime

# operation
- ~
- /, *, 
- ? :

- ^~ ~^ (同或)
- {}, 连接与复制
- 归约: &, ~&, |, ~|, ^, ^~(~^)


        &(归约与)——如果存在位值为0，那么结果为0；如果存在位值为x或z，则结果为x；否则结果为1
        ~&(归约与非)——与归约操作符&相反。
        | (归约或)——如果存在位值为1，那么结果为1；如果存在位值为x或z，则结果为x；否则结果为0。
        ~| (归约或非)——与归约操作符 | 相反。
        ^ (归约异或)——如果存在位值为x或z，那么结果为x；如果操作数中有偶数个1，则结果为0；否则结果为1。
        ~^ (归约异或非)——与归约操作符 ^ 相反。

- 选择a[3:0]: use a[2], use a[1:0]
- memory[], 不可选择

# 
- call function: $(for system)monitor(...)


# 

(1) 只有寄存器类型的信号才可以在always和initial 语句中进行赋值，类型定义通过reg语句实现；
(2) 采用行为级描述方式，即直接采用“+”来描述加法，{Cout，Sum}表示对位数的扩展，因为两个1 bit相加，产生的和有两位，低位放在Sum变量中，进位放在Cout 中；
(3)  always语句一直重复执行，由敏感列表(always语句括号内的变量)中的变量触发；
(4)  always语句从0时刻开始；
(5) 在begin和end之间的语句是顺序执行的，属于串行语句。

        always@(A or B or Cin)
            begin
                {Cout, Sum} = A + B + Cin;
                #10 //延时
            end
## 
每个过程块是由过程语句(initial或always)和语句块组成的，过程块中有下列部件：过程赋值语句——赋值语句和过程连续赋值语句；时序控制——控制块的执行及块中的语句时序；高级结构(循环，条件语句等)——描述块的功能。
　　Verilog HDL中的多数过程模块都从属于以下两种过程语句：
　　initial说明语句，只执行一次；
　　always说明语句；@:
- begin/end 
- fork-join(parallel)：延时相对与开始，disable to break

顺序语句块和并行语句块属于不同的过程块(initial或always过程块)时，顺序语句块和并行语句块是并行执行的。
当顺序语句块和并行语句块嵌套在同一条过程块内时，内层语句块可以看做外层语句块中的一条普通语句，内层语句块在什么时候得到执行是由外层语句块的规则所决定的；内层语句块开始执行后，其内部各条语句的执行要遵守内层语句块的规则。

- #
- 电平敏感事件控制方式下启动语句执行的触发条件是指定的条件表达式为真(1)。电平敏感事件控制用关键词“wait”来表示，有以下3种所示：
　　　wait (条件表达式) 语句块；
　　　wait (条件表达式) 行为语句；
　　　wait (条件表达式)；
- 边沿敏感事件触发：@(a)-a变化


assign  Z = a & b ; 		//连续赋值语句，给Z赋值 连续赋值语句执行时，只要等号右端的操作数上有事件发生(操作数值的变化)，右端表达式即被计算，如果结果值有变化，新结果就赋给等号左端的线网型变量。

        b<=a阻塞过程赋值只能用于寄存器赋值。非阻塞赋值在所在块结束之后才能真正完成赋值操作，如例4.15中，b的值并不是立刻改变的。

## flow 

> + begin/end

- if-else
- case
- casez和casex。其中casez语句忽略比较表达式两边的z部分，casex语句忽略比较表达式两边的x部分和z部分，即在表达式进行比较时，不将该位的状态考虑在内。这样，在case语句表达式进行比较时，就可以灵活地设置对信号的某些位进行比较

        casez(a)
        casex(a)
- forever: loop forever
- repeat(10)
- while
- for

# 结构级建模方法
- 一个输出：and U1(out, a, b, c) // nand, or, nor, xor, xnor,
- 一个输入: not U(a, b, c, in) // buf
- 三态门
