package org.learn.routerservice.implementation;

import org.learn.routerservice.contract.Router;
import org.learn.routerservice.exception.PathDoesNotExistException;
import org.learn.routerservice.exception.RouteNotAvailableException;

import java.util.concurrent.ConcurrentHashMap;

public class RouterImpl implements Router {

    private ConcurrentHashMap<String, String> routerInfoMap = new ConcurrentHashMap<>();

    @Override
    public String registerRoute(String path, String result) throws RouteNotAvailableException {
        if(null != routerInfoMap.get(path)){
            throw new RouteNotAvailableException("route is already taken, please provide a new path");
        }
        routerInfoMap.putIfAbsent(path, result);
        return "route ".concat(path).concat(" is registered");
    }

    @Override
    public String lookupRoute(String path) throws PathDoesNotExistException {
        if(null != routerInfoMap.get(path)){
            return routerInfoMap.get(path);
        }else{
            throw new PathDoesNotExistException("Provided path does not exist");
        }
    }
}
