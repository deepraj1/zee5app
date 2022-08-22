package com.zee.zee5app.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.WebSeries;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;

public class WebsIdGenerator implements IdentifierGenerator {
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		WebSeries movie = (WebSeries)object;
		Connection connection = null;
		connection = session.connection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id =0 ;
		int updatedresult =0;
		String newId = null;
		String query = "select userid from useridgenerator";
		String updatequery = "update useridgenerator set userid=?";
//		connection = this.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				id  = resultSet.getInt(1);
			
			++id;
			System.out.println("id = "+id);
			int no_digit = Integer.toString(id).length();
			String no_zeros = "";
			for(int i=0;i<10-no_digit;i++) {
				no_zeros=no_zeros+0;
			}
			newId = movie.getWebsName().charAt(0)+""+movie.getWebsName().charAt(1)+""+no_zeros+id;
			System.out.println(newId);
			preparedStatement = connection.prepareStatement(updatequery);
			preparedStatement.setInt(1	, id);
			updatedresult = preparedStatement.executeUpdate();
			if(updatedresult==0) {
				throw new UNableToGenerateIdException("unable to generate id");
			}
			return newId;
			}
		}catch (UNableToGenerateIdException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw new UNableToGenerateIdException("unable to generate id"+e.getMessage());
		}
		
		return null;
	}

}
