package com.atguigu.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class SecondRealm  extends AuthenticatingRealm {

	

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("secondRealm doGetAuthenticationInfo");
		//1b把AuthenticationToken对象转换成为UsernamePasswordToken
		UsernamePasswordToken upToken =(UsernamePasswordToken) token;
		//2从UsernamePasswordToken 中获取username
		String username=upToken.getUsername();
		//3调用数据库的方法，从数据看查寻username对应的用户记录
		System.out.println("从数据库中获取Username："+username+"所对应的用户信息");
		//4若用户不存在，则抛出异常UnknownAccountException
		if("unknow".equals(username)){
			throw new UnknownAccountException("用户不存在");
		}
		//5根据用户信息情况，决定是否抛出其他异常
		if("monster".equals(username)){
			throw new LockedAccountException("用户被锁定");
		}
		// info就是从数据库获取的密码账号对象
		//6根据用户情况来构建AuthenticationInfo对象并返回，通常使用的实现类是SimpleAuthenticationInfo
		//一下信息是从数据库中获取 1认证的实体信息，可以是username，可以是数据表对应的用户的实体对象
		Object principal=username;
		// 2密码 数据库中获取的
		Object credentials="53387f9299e3455b9b7510d4127d385b";
		if("admin".equals(username)){
			credentials="40561397f0540e3a2d0273ed9ec3bbc2738a3385";
		}else{
			credentials="658f759d8e652f2ff8da5c743f4ffacdf83ac4f8";
		}
		//3当前realm对象的name。调用父类的getname（）
		String realmName=getName();
		//4盐值
		ByteSource credentialsSalt =ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info= null;// 普通加密，如果密码相同则在数据库显示一样 new SimpleAuthenticationInfo(principal, credentials, realmName);
		//带盐值加密
		info=new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		
		System.out.println("doGetAuthenticationInfo"+token.hashCode());
		return info;
	}
	public static void main(String[] args) {
		String hashAlgorithmName="SHA1";//SHA1,MD5
		Object credentials ="123456";
		Object salt=ByteSource.Util.bytes("admin");//admin
		int hashIterations=100;
		Object result= new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println("==========="+result);
	}
	

}
