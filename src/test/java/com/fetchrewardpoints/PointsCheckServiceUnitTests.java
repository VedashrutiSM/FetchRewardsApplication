package com.fetchrewardpoints;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.fetchrewardpoints.domain.UserRecord;
import com.fetchrewardpoints.service.FetchRewardService;

@RunWith(MockitoJUnitRunner.class)
public class PointsCheckServiceUnitTests {
	
	@InjectMocks
	FetchRewardService fetchRewardsService;
	
	@Test
	public void addPointsTest() {
		
		UserRecord record1 = new UserRecord("DANNON",300,"10/31 10AM");
		UserRecord record2 = new UserRecord("UNILEVER",200,"10/31 11AM");
		UserRecord record3 = new UserRecord("DANNON",-200,"10/31 3PM");
		UserRecord record4 = new UserRecord("MILLER COORS",10000,"11/01 2PM");
		UserRecord record5 = new UserRecord("DANNON",1000,"11/01 3PM");
		fetchRewardsService.addPoints(record1);
		fetchRewardsService.addPoints(record2);
		fetchRewardsService.addPoints(record3);
		fetchRewardsService.addPoints(record4);
		fetchRewardsService.addPoints(record5);
		
		//Total points of DANNON is 1100 (300 - 200 + 1000)
		Map<String, Integer> totalRecords = fetchRewardsService.getPoints();
		int dannonPoints = totalRecords.get("DANNON");
		assertEquals(1100, dannonPoints);
	
	}
	
	@Test
	public void deductPoints() {
		
		
		UserRecord record1 = new UserRecord("DANNON",300,"10/31 10AM");
		UserRecord record2 = new UserRecord("UNILEVER",200,"10/31 11AM");
		UserRecord record3 = new UserRecord("DANNON",-200,"10/31 3PM");
		UserRecord record4 = new UserRecord("MILLER COORS",10000,"11/01 2PM");
		UserRecord record5 = new UserRecord("DANNON",1000,"11/01 3PM");
		fetchRewardsService.addPoints(record1);
		fetchRewardsService.addPoints(record2);
		fetchRewardsService.addPoints(record3);
		fetchRewardsService.addPoints(record4);
		fetchRewardsService.addPoints(record5);
		
		fetchRewardsService.deduct(5000);
		Map<String, Integer> totalRecords = fetchRewardsService.getPoints();
		
	
		int dannonPoints = totalRecords.get("DANNON");
		int unileverPoints = totalRecords.get("UNILEVER");
		int millercoorsPoints = totalRecords.get("MILLER COORS");
		// final points of each payer after deducting 5000 points
		assertEquals(1000, dannonPoints);
		assertEquals(0,unileverPoints);
		assertEquals(5300,millercoorsPoints);
		
	}

}
