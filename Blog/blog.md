# install

1. node.js
2. npm (or cnpm..)
3. sudo npm install -g hexo-cli 


# config

- mkdir blog
- cd
- 初始化：hexo init
- 生成页面：hexo s
- 增加文件：heso n "..."
 
    > cd 
    >
    > cd ../..

- hexo clean
- hexo g
- hexo d


# push

- github: liukanglai.github.io
- sudo npm install --save hexo-deployer-git
- vim \_config.yml

    > 低部:deployment
    >
    > type: git
    >
    > repo: https://github.com/liukanglai/liukanglai.github.io.git
    >
    > branch: master


- ssh-keygen -t rsa -C <Email> # <Email>替换为git配置的用户邮箱
- cat ~/.ssh/id_rsa.pub # 查看public key，复制内容到github账户设置页
- ssh -T git@github.com # 测试ssh认证


- hexo g
- hexo d

        使用自己的域名，用Git pages 解析：
        1. created a file CNAME, (防止在push时消失，建立在source文件夹中)
        2. write your 域名(无前缀，ps：liukanglai.tk) in it 
        3. 域名解析，加记录，可ip地址（ping 原域名得到），可直接原域名


# themes

- git clone ... themes/...
- vim \_config.yml
- theme: ...(修改)



# write

1. pages

    - post

      > hexo n ...

    - draft

      > hexo new draft ...
      >
      > hexo server --draft
      >

    - normal

      > hexo new page ...
      >
      > http://localhost:4000/.../


        vim _config.yml
        default_layout: ...
