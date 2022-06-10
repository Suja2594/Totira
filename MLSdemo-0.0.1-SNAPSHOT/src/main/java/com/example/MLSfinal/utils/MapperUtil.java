/**
 * 
 */
package com.example.MLSfinal.utils;

import java.util.List;



import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author JoShi
 *
 */

@Component
public class MapperUtil {

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	public <T, S> T map(S s, Class<T> targetClass) {
		return dozerBeanMapper.map(s, targetClass);
	}

	public <T, S> List<T> map(List<S> s, Class<T> targetClass) {
		return s.parallelStream().map(obj -> map(obj, targetClass)).collect(Collectors.toList());
	}

}
