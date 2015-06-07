package com.dongduk.movit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dongduk.movit.dao.MvSelectDao;
import com.dongduk.movit.domain.Member;
import com.dongduk.movit.domain.Movie;
import com.dongduk.movit.domain.StorageMv;
import com.dongduk.movit.domain.preferGenre;
import com.dongduk.movit.domain.WishMv;

@Repository
public class JdbcMvSelectDao implements MvSelectDao{
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	public JdbcMvSelectDao(DataSource dataSource){
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate2;
	
	//public JdbcMvSelectDao(DataSource dataSource){
	//	jdbcTemplate2 = new JdbcTemplate(dataSource);
	//}
	
	private static final String INSERT_STORAGE_SQL = 
			"insert into StorageMv (memberIdx, movieIdx, rate) values (:memberIdx, :movieIdx, :rate)";
	
	private static final String INSERT_WISH_SQL = 
			"insert into WishMv (memberIdx, movieIdx) values (:memberIdx, :movieIdx)";
	private static final String UPDATE_SQL = "";
			
	private static final String DELETE_SQL = "";	
	
	private static final String SELECT_RATE_SQL = "select rate from storagemv where movieIdx = ?";	
	
	private static final String SELECT_STORAGELIST_SQL = "select memberIdx, movieIdx, rate from storagemv where memberIdx = :memberIdx";
	
	private static final String SELECT_MVINFO_SQL = "select * from movie where movieIdx = :movieIdx";
	
	private static final String SELECT_WISHLIST_SQL = "select memberIdx, movieIdx from wishmv where memberIdx = :memberIdx";
	
	@Override
	public void insertStorage(StorageMv mv) {
	
		BeanPropertySqlParameterSource paramSource = new  BeanPropertySqlParameterSource(mv);
		
		System.out.println(mv.getMemberIdx());
		System.out.println(mv.getMovieIdx());
		System.out.println(mv.getRate());
		
		jdbcTemplate.update(INSERT_STORAGE_SQL, paramSource);
				
		System.out.println("insertStorage 성공");
	}

	//6.4
	public int getStoredRate(int MovieIdx){
		
		
		return MovieIdx;	
	}
	
	//5.22추가
	public void updateStorage(StorageMv s_mv){
		
	}
	
	//5.22추가
	public void deleteStorage(StorageMv s_mv){
		
	}
	
	public void updateUser(Member mem) {
		
	}
	
	public void insertWish(WishMv w_mv) {
		BeanPropertySqlParameterSource paramSource = new  BeanPropertySqlParameterSource(w_mv);
		jdbcTemplate.update(INSERT_WISH_SQL, paramSource);
		
		System.out.println("insertWish 성공");	
	}

	public void updateTasteGenre(preferGenre t_genre) {
		
	}

	public List<WishMv> getWishList(int memberIdx) {
		System.out.println("getWishList 진입");
	System.out.println("memberIdx : " + memberIdx);
	
	List<WishMv> wishList = jdbcTemplate2.query(SELECT_WISHLIST_SQL,
			new Object[] { memberIdx }, new int[] { java.sql.Types.INTEGER },
			new RowMapper<WishMv>() {
				public WishMv mapRow(ResultSet rs, int rowNum)throws SQLException {
					WishMv wish = new WishMv();
					
					wish.setMemberIdx(rs.getInt("MEMBERIDX"));
					wish.setMovieIdx(rs.getInt("MOVIEIDX"));
				
					return wish;
				}
			});
	
	System.out. println(wishList.size());
	System.out. println("getWishList 성공");
	return wishList;	  
	}

	
	public List<StorageMv> getStorageList(int memberIdx) {
		System.out.println("getStorageList 진입");
		System.out.println("memberIdx : " + memberIdx);
		
		List<StorageMv> StorageList = jdbcTemplate2.query(SELECT_STORAGELIST_SQL,
				new Object[] { memberIdx }, new int[] { java.sql.Types.INTEGER },
				new RowMapper<StorageMv>() {
					public StorageMv mapRow(ResultSet rs, int rowNum)throws SQLException {
						StorageMv storage = new StorageMv();
						System.out.println(rs.getInt("MEMBERIDX"));
						System.out.println(rs.getInt("MOVIEIDX"));
						System.out.println(rs.getString("RATE"));
						
						storage.setMemberIdx(rs.getInt("MEMBERIDX"));
						storage.setMovieIdx(rs.getInt("MOVIEIDX"));
						storage.setRate(rs.getString("RATE"));
					
						return storage;
					}
				});
		
		System.out. println(StorageList.size());
		System.out. println("getStorageList 성공");
		return StorageList;	  
	}
	
	// 6.6
	public Movie getMvInfo(int movieIdx) {
		System.out.println("getMvInfo 진입");
		Movie mv = jdbcTemplate2.queryForObject(SELECT_MVINFO_SQL,
				new Object[] { movieIdx }, new int[] { java.sql.Types.INTEGER },
				new RowMapper<Movie>() {
					public Movie mapRow(ResultSet rs, int rowNum)throws SQLException {
						Movie mv = new Movie();
						
						mv.setMovieIdx(rs.getInt("MOVIEIDX"));
						mv.setTitle(rs.getString("TITLE"));
						mv.setGenre(rs.getString("GENRE"));
						mv.setDirector(rs.getString("DIRECTOR"));
						mv.setNation(rs.getString("NATION"));
						mv.setImg(rs.getString("IMG"));
						
						return mv;
					}
				});
		
		System.out. println("getMvInfo 성공");
		return mv;	  
	}

	
}
