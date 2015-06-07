package com.dongduk.movit.dao;

import java.util.List;

import com.dongduk.movit.domain.Member;
import com.dongduk.movit.domain.Movie;
import com.dongduk.movit.domain.StorageMv;
import com.dongduk.movit.domain.preferGenre;
import com.dongduk.movit.domain.WishMv;

@SuppressWarnings("serial")
public interface MvSelectDao {

	void insertStorage(StorageMv s_mv);
	
	/*5.22 추가*/
	void updateStorage(StorageMv s_mv);
	
	void deleteStorage(StorageMv s_mv);
	
	/**/
	
	void updateUser(Member mem);
	
	void insertWish(WishMv w_mv);

	void updateTasteGenre(preferGenre t_genre);

	List<StorageMv> getStorageList(int memberIdx);
	
	/*6.4추가*/
	
	int getStoredRate(int movieIdx);
	//boolean isStored(int movieIdx);
	
	//6.6
	Movie getMvInfo(int movieIdx);

	List<WishMv> getWishList(int memberIdx);

}
