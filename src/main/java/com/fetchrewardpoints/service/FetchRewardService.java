package com.fetchrewardpoints.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fetchrewardpoints.domain.UserRecord;

@Service
public class FetchRewardService {

	// LinkedList to maintain the order 
	List<UserRecord> recordQueue = new LinkedList<UserRecord>();

	// Map to maintain the points for every payer
	Map<String, Integer> map = new HashMap<>();

	public void addPoints(UserRecord record) {
		
		if (!map.containsKey(record.getPayerName())) {			
			map.put(record.getPayerName(), record.getPoints());
		} else {
			map.put(record.getPayerName(), map.get(record.getPayerName()) + record.getPoints());			
		}		
		
		if(record.getPoints()< 0) {
										
			int i=0;
			int points = -record.getPoints();
			while(i<recordQueue.size() && points>0) {
				
				UserRecord rec = recordQueue.get(i);
				int recPoints = rec.getPoints();
				
				if(rec.getPayerName().equals(record.getPayerName())) {
					
					if(recPoints >= points) {
						rec.setPoints(recPoints-points);
						points = 0;
												
					}else {
						points = points - recPoints;
						rec.setPoints(0);
					}						
				}	
				i++;
			}
		}	
		recordQueue.add(record);
	}
	

	public List<UserRecord> deduct(int points) {

		int pointsCount = points;
			
		// List of records to be returned from which points are deducted
		List<UserRecord> list = new ArrayList<>();
		int i = 0;
		
		while (pointsCount > 0 && i<recordQueue.size()) {

			UserRecord r = recordQueue.get(i);

			// if points is in negative then
			if (r.getPoints() > 0) {

				if (r.getPoints() <= pointsCount) {

					// add to the list to be returned
					UserRecord addToList = new UserRecord();
					addToList.setPayerName(r.getPayerName());
					addToList.setPoints(-r.getPoints());
					addToList.setTransactionDate("now");
					list.add(addToList);

					// update the map for given payer
					map.put(r.getPayerName(), map.get(r.getPayerName()) - r.getPoints());

					// update the points
					pointsCount = pointsCount - r.getPoints();

					// remove the record from the linkedlist
					//recordQueue.remove(i);
					i++;
				} else {

					// add to the list to be returned
					UserRecord addToList = new UserRecord();
					addToList.setPayerName(r.getPayerName());
					addToList.setPoints(-pointsCount);
					addToList.setTransactionDate("now");
					list.add(addToList);

					// update the remaining points in the record
					int updatePoints = r.getPoints() - pointsCount;
					pointsCount = 0;
					r.setPoints(updatePoints);

					map.put(r.getPayerName(), updatePoints);
				}
			} else {
				i++;
			}
		}
		return list;
	}

	public Map<String, Integer> getPoints() {		
		return map;
	}

}
