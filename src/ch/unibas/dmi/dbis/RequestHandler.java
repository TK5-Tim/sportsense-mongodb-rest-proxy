/*
 * SportSense
 * Copyright (C) 2019  University of Basel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ch.unibas.dmi.dbis;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class RequestHandler extends AbstractHandler {

  private MongoDBRestProxy dbProxy;

  public RequestHandler(MongoDBRestProxy dbProxy) {
    this.dbProxy = dbProxy;
  }

  @Override
  public void handle(String target, Request request, HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) throws IOException, ServletException {

    switch (target) {
      case "/getAreaEvents":
        getAreaEvents(httpServletRequest, httpServletResponse);
        break;
      case "/getMotionPath":
        getMotionPath(httpServletRequest, httpServletResponse);
        break;
      case "/getEventCascade":
        getEventCascade(httpServletRequest, httpServletResponse);
        break;
      case "/getEventTypes":
        getEventTypes(httpServletRequest, httpServletResponse);
        break;
      case "/getPlayers":
        getPlayers(httpServletRequest, httpServletResponse);
        break;
      case "/getTeams":
        getTeams(httpServletRequest, httpServletResponse);
        break;
      case "/getMatches":
        getMatches(httpServletRequest, httpServletResponse);
        break;
      case "/saveFilter":
        saveFilter(httpServletRequest, httpServletResponse);
        break;
      case "/saveEventCascade":
        saveEventCascade(httpServletRequest, httpServletResponse);
        break;
      case "/getQueries":
        getQueries(httpServletRequest, httpServletResponse);
        break;
      case "/delQuery":
        deleteSavedQuery(httpServletRequest, httpServletResponse);
        break;
      case "/rerunQuery":
        rerunQuery(httpServletRequest, httpServletResponse);
        break;
      case "/analyzePlayers":
        analyzePlayers(httpServletRequest, httpServletResponse);
        break;
      case "/analyzeQueries":
        analyzeQueries(httpServletRequest, httpServletResponse);
        break;
      default:
        getDefaultResult(httpServletRequest, httpServletResponse);
    }
    request.setHandled(true);
  }

  public void saveEventCascade(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    // System.out.println(httpServletResponse);


    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.saveEventCascade(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    writer.println(response.getContent());
  }

  private void analyzeQueries(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    // System.out.println(httpServletResponse);


    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.analyzeQueries(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    writer.println(response.getContent());
  }

  private void analyzePlayers(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    // System.out.println(httpServletResponse);


    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.analyzePlayers(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    // System.out.println("We got this response" + response.getContent());
    writer.println(response.getContent());
  }

  private void saveFilter(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.saveFilter(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    writer.println(response.getContent());
  }

  private void deleteSavedQuery(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    PrintWriter writer = null;

    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.deleteSavedQuery(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    // System.out.println("We got this response" + response.getContent());
    writer.println(response.getContent());
  }

  private void rerunQuery(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.rerunQuery(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    writer.println(response.getContent());
  }

  private void getQueries(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    // System.out.println("Parameter map is" + httpServletRequest.getParameterMap().toString());

    Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();

    if (!parameterMap.isEmpty()) {
      // System.out.println("ParameterMap is not empty");
      if (httpServletRequest.getParameter("method").equals("delQuery")) {
        response.deleteSavedQuery(httpServletRequest);
      } else if (httpServletRequest.getParameter("method").equals("rerunQuery")) {
        response.rerunQuery(httpServletRequest);
      }
    } else {
      response.getQueries(httpServletRequest);
    }

    httpServletResponse.setStatus(response.getHttpStatusCode());
    writer.println(response.getContent());
  }

  private void getTeams(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.getTeams(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    writer.println(response.getContent());
  }

  private void getPlayers(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.getPlayers(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    writer.println(response.getContent());
  }

  private void getEventTypes(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.getEventTypes(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    writer.println(response.getContent());
  }

  private void getMatches(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.getMatches(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    writer.println(response.getContent());
  }

  private void getEventCascade(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.getEventCascade(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    writer.println(response.getContent());

  }

  private void getMotionPath(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.getMotionPath(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    writer.println(response.getContent());
  }

  private void getAreaEvents(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {

    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      e.printStackTrace();
    }

    RestResponse response = new RestResponse();

    response.getAreaEvent(httpServletRequest);
    httpServletResponse.setStatus(response.getHttpStatusCode());
    writer.println(response.getContent());
  }

  private void getDefaultResult(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
    httpServletResponse.setContentType("text/plain;charset=utf-8");
    PrintWriter writer = null;

    try {
      writer = httpServletResponse.getWriter();
    } catch (IOException e) {
      // MongoDBRestProxy.logger.error(e.getMessage());
      e.printStackTrace();
    }

    RestResponse restResponse = new RestResponse();

    restResponse.getDefaultResponse();
    httpServletResponse.setStatus(restResponse.getHttpStatusCode());
    writer.println(restResponse.getContent());
  }
}
