package com.atguigu.shiro.realms;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.atguigu.shiro.factory.FilterChainDefinitionMapBuilder;

public class ShiroRealm  extends AuthorizingRealm {

	//��Ȩ�ᱻ�ص��ķ���
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		//1��PrincipalCollection��ȡ�ĵ�½��Ϣ
		Object principal=principals.getPrimaryPrincipal();
		//2���õ�½�û���Ϣ���û���ǰ�û��Ľ�ɫ��Ȩ�ޣ����ܲ�ѯ���ݿ⣩
		Set<String> roles =new HashSet<>();
		//admin��½��2����ɫ
		roles.add("user");
		if("admin".equals(principal)){
			roles.add("admin");
		}
		//3����SimpleAuthenticationInfo,��������reles����
		SimpleAuthorizationInfo info =new SimpleAuthorizationInfo(roles);
		//4����SimpleAuthenticationInfo����
		return info;
 	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		System.out.println("FirstRealm doGetAuthenticationInfo");
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
			credentials="0ea9114a57ee221805a9cd4f1ce40663";
		}else{
			credentials="bac947aef187c26e7878bcc651dcd2e3";
		}
		//3��ǰrealm�����name�����ø����getname����
		String realmName=getName();
		//4��ֵ
		ByteSource credentialsSalt =ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info= null;// ��ͨ���ܣ����������ͬ�������ݿ���ʾһ�� new SimpleAuthenticationInfo(principal, credentials, realmName);
		//����ֵ����
		info=new SimpleAuthenticationInfo("secondRealmName", credentials, credentialsSalt, realmName);
		
		System.out.println("doGetAuthenticationInfo"+token.hashCode());
		return info;
		//ShiroFilterFactoryBean s   org.apache.shiro.spring.web.ShiroFilterFactoryBean.filterChainDefinitionMap
		
	}
	public static void main(String[] args) {
		String hashAlgorithmName="MD5";
		Object credentials ="123456";
		Object salt=ByteSource.Util.bytes("user");//admin
		int hashIterations=100;
		Object result= new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println("==========="+result);
	}
	

}
