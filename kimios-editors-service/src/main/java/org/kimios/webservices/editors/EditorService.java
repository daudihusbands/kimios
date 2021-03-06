/*
 * Kimios - Document Management System Software
 * Copyright (C) 2008-2016  DevLib'
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * aong with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.kimios.webservices.editors;

import io.swagger.annotations.Api;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.kimios.editors.model.EditorData;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@WebService(targetNamespace = "http://kimios.org", serviceName = "EditorService")
@CrossOriginResourceSharing(allowAllOrigins = true)
@Api(value = "/editors", description = "External Editors Workflow Operations")
public interface EditorService {


    @GET
    @Path("/edit")
    @Produces(value = {
            MediaType.APPLICATION_JSON
    })
    public EditorData startDocumentEdit(@QueryParam(value = "sessionId")
                                        String sessionId,
                                        @QueryParam(value = "documentId")  long documentId) throws Exception;


    @POST
    @Path("/version")
    @Consumes(value = {
            MediaType.APPLICATION_JSON
    })
    @Produces(value = {
            MediaType.APPLICATION_JSON
    })
    public EditorData versionDocument(@QueryParam(value = "sessionId")
                                          String sessionId, EditorData editData) throws Exception;


    @POST
    @Path("/finish")
    @Consumes(value = {
            MediaType.APPLICATION_JSON
    })
    @Produces(value = {
            MediaType.APPLICATION_JSON
    })
    public EditorData endDocumentEdit(@QueryParam(value = "sessionId")
                                          String sessionId, EditorData editData) throws Exception;


}
