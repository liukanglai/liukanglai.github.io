#

- sudo gunzip ***.gz
- chmod +x clash***
- ./clash -d
- 

    config.yml和config.yaml
当你在网页上点了半天确认，clash却不给你回应的时候，其实问题就出现在这里
你需要把config.yml里面的内容复制到config.yaml里面，至于config.yml怎么来就看各位自个了
其余步骤相信都不用多说。


# shellclash


- source ~/.bashrc &> /dev/null

启动脚本：clash

启动clash服务：$clashdir/start.sh start

停止clash服务：$clashdir/start.sh stop

重启clash服务：$clashdir/start.sh restart

更新订阅文件：$clashdir/start.sh getyaml


~/.config/clash
/usr/lib/systemd/system/clash@.service:

        [Unit]
        Description=A rule based proxy in Go for %i.
        After=network.target

        [Service]
        Type=exec
        User=%i
        Restart=on-abort
        ExecStart=/usr/bin/clash

        [Install]
        WantedBy=multi-user.target
