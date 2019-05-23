package com.system.dao;

import com.common.BaseDAO;
import com.common.LoginUser;


public class IndexDAO extends BaseDAO {

	/**
	 * 获取登录用户
	 * 
	 * @return
	 */
	public LoginUser selectUserBean(String username, String password) {
		Object[] params = { username, password };
		return j.queryForBean(
						LoginUser.class,
						"SELECT * from s_user WHERE username=? and password=? ",
						params);
	}

}
