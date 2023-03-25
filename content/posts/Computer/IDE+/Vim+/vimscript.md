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
---# vim 脚本文件

- 使用 : 去执行命令 (单步调试) :source 执行整个脚本文件
- 后缀.vim
- :source *.vim (:so %)
- :echo variable(print it)

# grammar

> 无专门的boolean, 1 is true, 0 is false

## variables

1. set(inner variable)

2. let 非内部变量的赋值
    - let g:hh='liu' g作用域
    - g全局（默认的） v（vim定义的全局作用域） l（局部，函数内部默认） b（当前缓冲区） w（当前窗口） t（当前标签页） s(使用:source'd执行的vim脚本文件中的局部文件作用域)  a(函数的参数)
    - let @a='liu' (寄存器)
    - let &ignorecase = 0 (可用&访问set命令的变量，即内部变量)

> 整数变量可用+ - \* / 运算，字符串拼接使用 . (如: 'h'.'ello'), 字符串内使用 ' (要使用两个 '')
>> '内为字符串, "内可有非字面量字符, 但注释也使用, 所以有些命令后面不能用注释

3. echo
    - echo g:animal  (echomsg/echom can keep the msg to log, use :messages can look up)
    > :help message-history

## conditionals

1. if
    
        if animal == 'cat'
            ...
        elseif ...
            ...
        else
            ...
        endif

    - ? : 
    - if !(cat || dog)  if !cat && !dog
    - == 比较字符串，==? 忽略大小写, ==# 考虑大小写, =~ 左操作数与右操作数匹配(=~? =~#), !~ 反=~ 
    - 默认大小写取决于ignorecase
            
            echo 'cat' ==? 'CAT'
            echo 'cat' ==# 'CAT'
            set ignorecase | echo 'cat' == 'CAT'
            echo 'cat' =~ 'c.\+'
            echo 'cat' =~# 'C.\+'
            echo 'cat' !~ '.at'
            echo 'cat' !~? 'C.\+'

## lists

- let animals = ['cat', 'dog', 'parrot']

- let cat = animals[0]      " get first element
- let dog = animals[1]      " get second element
- let parrot = animals[-1]  " get last element
- let slice = animals[1:] let slice = animals[0:1]  " include begin and end elements

- call add(animals, 'octopus') or let animals = add(animals, 'octopus')
> 除非函数是表达式的一部分, 否则单独调用都要call 
- call insert(animals, 'bobcat')  " at first
- call insert(animals, 'raven', 2)  " assign index

- unlet animals[2]  " delete
- call remove(animals, -1)
- unlet animals[:1]   call remove(animals, 0, 1)


- let mammals = ['dog', 'cat']
- let birds = ['raven', 'parrot']

- let animals = mammals + birds
- call extend(mammals, birds)

- call sort(animals)   " 按字母排序

- let i = index(animals, 'parrot')  " i is 2

        if empty(animals)
          echo 'There aren''t any animals!'
        endif

- echo 'There are ' . len(animals) . ' animals.'    " len get the length of lists
- echo 'There are ' . count(animals, 'cat') . ' cats here.'    " count can get how much the element in list

> :help list

## dictionaries

    let animal_names = {
      \ 'cat': 'Miss Cattington',
      \ 'dog': 'Mr Dogson',
      \ 'parrot': 'Polly'
      \ }

- use \ to wrap lines

- let cat_name = animal_names['cat']  or let cat_name = animal_names.cat   " get an element
> the . 只适用于元素仅包含数字, 字母, 下划线

- let animal_names['raven'] = 'Raven R. Raventon'
- unlet animal_names['raven']  or  let raven = remove(animal_names, 'raven')

- call extend(animal_names, {'bobcat': 'Sir Meowtington'})  " extend two dictionaries, change the first, if have the same elements, it will cover

        if !empty(animal_names)
          echo 'We have names for ' . len(animal_names) . ' animals'
        endif

        if has_key(animal_names, 'cat')  " if have the element
          echo 'Cat''s name is ' . animal_names['cat']
        endif

> :help dict

## loop

    for animal in animals
      echo animal
    endfor

    for animal in keys(animal_names)
      echo 'This ' . animal . '''s name is ' . animal_names[animal]
    endfor

    for [animal, name] in items(animal_names)
      echo 'This ' . animal . '''s name is ' . name
    endfor

    for animal in animals
      if animal == 'cat'
        echo 'It''s a cat! Breaking!'
        break
      endif
      echo 'Looking at a ' . animal . ', it''s not a cat yet...'
    endfor

    for animal in animals
      if animal == 'cat'
        echo 'Ignoring the cat...'
        continue
      endif
      echo 'Looking at a ' . animal
    endfor

    while !empty(animals)
      echo remove(animals, 0)
    endwhil

    while len(animals) > 0
      let animal = remove(animals, 0)
      if animal == 'dog'
        echo 'Encountered a dog, breaking!'
        break
      endif
      echo 'Looking at a ' . animal
    endwhile


## function

- 定义的函数必须大写开头（除非在脚本作用域或命名空间中）
- 函数内访问参数需 a: 作用域

        function! AnimalGreeting(animal)
          echo a:animal . ' says hello!'
        endfunction
        
        call AnimalGreeting('cat')

- vimscript 可能加载多次，重定可能出错，可加! 

        function! AnimalGreeting(animal)
          return a:animal . ' says hello!'
        endfunction
        
        echo AnimalGreeting('dog')   " 输出函数的返回值
        
        function! AnimalGreeting(...)  " 可变参
          echo a:1 . ' says hi to ' . a:2
        endfunction
        
        call AnimalGreeting('cat', 'dog')
        
        function! ListArgs(...)
          echo a:000  " get all arguments
        endfunction
        
        call ListArgs('cat', 'dog', 'parrot')
        
        function! AnimalGreeting(animal, ...)
          echo a:animal . ' says hi to ' . a:1
        endfunction
        
        call AnimalGreeting('cat', 'dog')


        function s:AnimalGreeting(animal)   " 局部作用域
          echo a:animal . 'says hi!'
        endfunction
        
        call s:AnimalGreeting('cat')

## classes

        let animal_names = {
          \ 'cat': 'Miss Cattington',
          \ 'dog': 'Mr Dogson',
          \ 'parrot': 'Polly'
          \ }
        
        function! animal_names.GetGreeting(animal)
          return self[a:animal] . ' says hello'
        endfunction
        
        echo animal_names.GetGreeting('cat')
        
        let animals = {
          \ 'animal_names' : {
            \ 'cat': 'Miss Cattington',
            \ 'dog': 'Mr Dogson',
            \ 'parrot': 'Polly'
            \ }
          \ }
        
        " 为类加函数
        function GetGreeting(animal) dict
          return self.animal_names[a:animal] . ' says hello'
        endfunction
        
        let animals['GetGreeting'] = function('GetGreeting')
        
        echo animals.GetGreeting('dog')

## lambda

    let AnimalGreeting = {animal -> animal . ' says hello'}

    echo AnimalGreeting('cat')

- 清晰函数

## map / filter

        function! IsProperName(name)
          if a:name =~? '\(Mr\|Miss\) .\+'
            return 1
          endif
          return 0
        endfunction
        
        let animal_names = {
          \ 'cat': 'Miss Cattington',
          \ 'dog': 'Mr Dogson',
          \ 'parrot': 'Polly'
          \ }
        
        call filter(animal_names, 'IsProperName(v:val)')
        
        let IsProperName2 = function('IsProperName')
        
        echo IsProperName2('Mr Dogson')
        
        function! FunctionCaller(func, arg)
          return a:func(a:arg)
        endfunction
        
        echo FunctionCaller(IsProperName2, 'Miss Catington')
        
        function! IsProperNameKeyValue(key, value)
          if a:value =~? '\(Mr\|Miss\) .\+'
            return 1
          endif
          return 0
        endfunction
        
        call filter(animal_names, function('IsProperNameKeyValue'))
        
        echo animal_names
        
        let animal_names = ['Miss Cattington', 'Mr Dogson', 'Polly', 'Meowtington']
        
        call map(animal_names,
          \ {key, val -> IsProperName(val) ? val : 'Miss ' .  val})
        
        echo animal_names
        
        function! MakeProperName(name)
          if IsProperName(a:name)
            return a:name
          endif
          return 'Miss ' . a:name
        endfunction
        call map(animal_names, 'MakeProperName(v:val)')

## interacting

    echo animal . ' says hello'   execute 'echo ' . animal . ' says hello'
    
    execute "normal /cat<cr>dw"  " <cr> is ctrl+v+enter, 要忽略自定义的键映射，use normal!
    
    " silent to hide command, add ! to hide external commands
    silent echo animal . ' says hello'
    silent execute 'echo ' . animal . ' says hello'
    silent !echo 'this is running in a shell'
    
    if has('python3')
      echom 'Your Vim was compiled with Python 3 support!'
    endif

- :help feature-list

## file

    echom 'Current file extension is ' . expand('%:e')
    
    if filereadable(expand('%'))
      echom 'Current file (' . expand('%:t') . ') is readable!'
    endif
    
    execute 'edit animals.py'

## prompts

let answer = confirm('Is cat your favorite animal?', "&yes\n&no")
echo answer

let answer = confirm(
  \ 'Is cat your favorite animal?', "absolutely &yes\nhell &no")

let animal = input('What is your favorite animal? ')
echo "\n"
echo 'What a coincidence! My favorite animal is a ' . animal . ' too!'

function! AskAnimalName()
  call inputsave()
  let name = input('What is the animal''s name? ')
  call inputrestore()
  return name
endfunction

nnoremap <leader>a = :let name = AskAnimalName()<cr>:echo name<cr>


# style

# plugin
