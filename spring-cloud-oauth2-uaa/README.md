# spring-cloud-oauth2-uaa代码  
  uaa:Unified identity authentication and authorization
  基于spring-cloud-simple开发，项目地址：https://github.com/kinglong198404/spring-cloud-architecture


项目构建过程说明：
http://blog.klfront.com/item/290.html


报错：
<error_description>Cannot convert access token to JSON</error_description>
<error>invalid_token</error>

uaa_security的 String SIGNING_KEY = "uaa123";
zuul_gateway的 String SIGNING_KEY = "uaa_kl";

