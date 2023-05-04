# virtualenv

## pip 安装包在 python3 的 site-packages

```
pip3 install virtualenv
mkdir pyproject
cd pyproject
virtualenv --no-site-packages venv
source venv/bin/activate (在这个环境目录下可安装第三方包)
deactivate
```
