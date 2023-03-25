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
---# documentclass 

\documentclass[a4paper]{article(book, report, ...)}

\begin{document}

Hello World !  % This is your content

\end{document}

# title

        \documentclass[UTF8]{ctexart}
        \title{你好，world!}
        \author{Liam}
        \date{\today}
        \begin{document}
        \maketitle
        你好，world!
        \end{document}

# List

1. Unordered List
 
        \begin{itemize}
        \item Item.
        \item Another Item.
        \end{itemize}

2. Ordered List

        \begin{enumerate}
        \item Item.
        \item Another Item.
        \end{enumerate}

# Paragraph and section

- \paragraph{} and \subparagraph{}
- \section{} and \subsection{}
- use \tableofcontents to create contents


- \newpage
- \newline  or \\
- \bigskip :空行

> 在report/ctexrep中，还有\chapter{·}；在文档类book/ctexbook中，还定义了\part{·}

# Footnotes

        Hi let me introduce myself\footnote{\label{myfootnote}Hello footnote}.
        ... (later on)
        I'm referring to myself \ref{myfootnote}.


# Table

        \begin{table}[h!]
          \centering
          \caption{Caption for the table.}
          \label{tab:table1}
          \begin{tabular}{l|c||r}
            1 & 2 & 3\\
            \hline
            a & b & c\\
          \end{tabular}
        \end{table}

- \usepackage{booktabs} for a visually better table.
- h (here) — same location
- t (top) — top of page
- b (bottom) — bottom of page
- p (page) — on an extra page
- ! (override) — will force the specified location


> 先写\caption{}再写\label{}

# Images

- \usepackage{graphicx}

        \begin{figure}
        \includegraphics[width=\linewidth]{filename.jpg}
        \includegraphics[scale=0.5]{HardwareInfo}
        \caption{What is it about?}
        \label{fig:whateverlabel}
        \end{figure}

- \includegraphics[width = .8\textwidth]{a.jpg}
这样图片的宽度会被缩放至页面宽度的百分之八十，图片的总高度会按比例缩放。

# Code

1. 

        \begin{verbatim}
        #include <iostream>
        
        int main()
        {
        	std::cout << "hello world!\n";
        	return 0;
        }
        \end{verbatim}

2. including insert code inline, make custom styles code, choose a specific language for code, import code from another file within the same directory.... With this method, you dont use {verbatim}, but include a package package named listings.

        \usepackage{listings}
        \usepackage{color}
        
        \lstdefinestyle{mystyle}{
        keywordstyle=\color{magenta},
        backgroundcolor=\color{yellow},
        commentstyle=\color{green},
        basicstyle=\footnotesize,
        }
        \lstset{style=mystyle}

        \begin{lstlisting}[language=Python]
        print "Hello World!"
        \end{lstlisting}
        \lstinputlisting[language=C++]{hello.cpp} %import a file named hello.cpp in the same directory
        \lstinline{} %inset inline code

# Math

- 使用 $ ... $ 可以插入行内公式，使用 \[ ... \] 可以插入行间公式
- \begin{equation} ...  \end{equation}
- \usepackage{amsmath}

        Einstein 's $E=mc^2$.
        \[ E=mc^2. \]
        \begin{equation}
        E=mc^2.
        E=mc^{2\pi}
        E=log_23
        \end{equation}
        $\sqrt{x}$, $\frac{1}{2}$.
- https://liam.page/2014/09/08/latex-introduction/


# Escape

- the _ 
