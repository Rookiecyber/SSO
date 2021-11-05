# SSO
利用Java EE技术实现一个单点登录系统，用户仅需要在该系统中登录一次，即可以访问互信的多个应用系统
## token认证
采用了jwt实现token认证，token存储在客户端中的cookie中。进入系统A和系统B中会拦截查询cookie中token是否有效，验证成功后才能进入。两个系统共用cookie，实现只用登录一次就能访问2个系统
## app1
127.0.0.1:8081/app1/index
## app2
127.0.0.1:8082/app2/index
## 认证服务器
127.0.0.1:8080/auth/login  
127.0.0.1:8080/auth/index
