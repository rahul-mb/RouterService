package org.learn.routerservice.contract;

import org.learn.routerservice.exception.PathDoesNotExistException;
import org.learn.routerservice.exception.RouteNotAvailableException;

public interface Router {

    String registerRoute(String path, String result) throws RouteNotAvailableException;
    String lookupRoute(String path) throws PathDoesNotExistException;


}
