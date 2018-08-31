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
		//1b��AuthenticationToken����ת����ΪUsernamePasswordToken
		UsernamePasswordToken upToken =(UsernamePasswordToken) token;
		//2��UsernamePasswordToken �л�ȡusername
		String username=upToken.getUsername();
		//3�������ݿ�ķ����������ݿ���Ѱusername��Ӧ���û���¼
		System.out.println("�����ݿ��л�ȡUsername��"+username+"����Ӧ���û���Ϣ");
		//4���û������ڣ����׳��쳣UnknownAccountException
		if("unknow".equals(username)){
			throw new UnknownAccountException("�û�������");
		}
		//5�����û���Ϣ����������Ƿ��׳������쳣
		if("monster".equals(username)){
			throw new LockedAccountException("�û�������");
		}
		// info���Ǵ����ݿ��ȡ�������˺Ŷ���
		//6�����û����������AuthenticationInfo���󲢷��أ�ͨ��ʹ�õ�ʵ������SimpleAuthenticationInfo
		//һ����Ϣ�Ǵ����ݿ��л�ȡ 1��֤��ʵ����Ϣ��������username�����������ݱ��Ӧ���û���ʵ�����
		Object principal=username;
		// 2���� ���ݿ��л�ȡ��
		Object credentials="53387f9299e3455b9b7510d4127d385b";
		if("admin".equals(username)){
			credentials="40561397f0540e3a2d0273ed9ec3bbc2738a3385";
		}else{
			credentials="658f759d8e652f2ff8da5c743f4ffacdf83ac4f8";
		}
		//3��ǰrealm�����name�����ø����getname����
		String realmName=getName();
		//4��ֵ
		ByteSource credentialsSalt =ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info= null;// ��ͨ���ܣ����������ͬ�������ݿ���ʾһ�� new SimpleAuthenticationInfo(principal, credentials, realmName);
		//����ֵ����
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
