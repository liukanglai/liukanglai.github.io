from flask import Flask, render_template, request

app = Flask(__name__)

student = [{
    'name': 'liukanglai',
    'credits': '21',
    'signature': 'Liu'
}, {
    'name': 'liukanglai0',
    'credits': '210',
    'signature': 'Liu0'
}]


@app.route('/')  # 默认的 GET 内容
def hello_world():  # put application's code here
    # 返回网页文件
    return render_template('index.html')


@app.route('/login', methods=['POST'])
def hello_login():
    # 登录到服务器 获取用户名与密码，再校验，再记录，再返回后台页面
    # print(request.form)  # 看看这个是啥

    username = request.form.get('title')
    password = request.form.get('password')

    # sql check user!

    return render_template('admin.html', slist=student)


@app.route('/delete/<name>')
def hello_delete(name):
    for item in student:
        if item['name'] == name:
            student.remove(item)
    return render_template('admin.html', slist=student)


@app.route('/change/<name>')
def hello_change(name):
    for item in student:
        if item['name'] == name:
            return render_template('change.html', user=item)
        else return render_template('admin.html', message='Bad')


@app.route('/changed/<name>', methods=['POST'])
def hello_changed(name):
    for item in student:
        if item['name'] == name:
            item['name'] = request.form.get('name')
            item['credits'] = request.form.get('credits')
            item['signature'] = request.form.get('signature')
    return render_template('admin.html', slist=student)


if __name__ == '__main__':
    app.run()
