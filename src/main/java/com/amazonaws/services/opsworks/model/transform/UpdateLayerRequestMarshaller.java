/*
 * Copyright 2010-2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.opsworks.model.transform;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.opsworks.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * Update Layer Request Marshaller
 */
public class UpdateLayerRequestMarshaller implements Marshaller<Request<UpdateLayerRequest>, UpdateLayerRequest> {

    

    public Request<UpdateLayerRequest> marshall(UpdateLayerRequest updateLayerRequest) {
    if (updateLayerRequest == null) {
        throw new AmazonClientException("Invalid argument passed to marshall(...)");
    }

        Request<UpdateLayerRequest> request = new DefaultRequest<UpdateLayerRequest>(updateLayerRequest, "AWSOpsWorks");
        String target = "OpsWorks_20130218.UpdateLayer";
        request.addHeader("X-Amz-Target", target);
        request.addHeader("Content-Type", "application/x-amz-json-1.1");

        
        request.setHttpMethod(HttpMethodName.POST);


        String uriResourcePath = ""; 

        uriResourcePath = uriResourcePath.replaceAll("//", "/");

        if (uriResourcePath.contains("?")) {
            String queryString = uriResourcePath.substring(uriResourcePath.indexOf("?") + 1);
            uriResourcePath    = uriResourcePath.substring(0, uriResourcePath.indexOf("?"));

            for (String s : queryString.split("[;&]")) {
                String[] nameValuePair = s.split("=");
                if (nameValuePair.length == 2) {
                    request.addParameter(nameValuePair[0], nameValuePair[1]);
                } else {
                    request.addParameter(s, null);
                }
            }
        }

        request.setResourcePath(uriResourcePath);


        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          
            
          jsonWriter.object();
          
            if (updateLayerRequest.getLayerId() != null) {
                jsonWriter.key("LayerId").value(updateLayerRequest.getLayerId());
            }
            if (updateLayerRequest.getName() != null) {
                jsonWriter.key("Name").value(updateLayerRequest.getName());
            }
            if (updateLayerRequest.getShortname() != null) {
                jsonWriter.key("Shortname").value(updateLayerRequest.getShortname());
            }
            if (updateLayerRequest.getAttributes() != null) {
                jsonWriter.key("Attributes");
                jsonWriter.object();
                for (Map.Entry<String, String> attributesListValue : updateLayerRequest.getAttributes().entrySet()) {
                    if (attributesListValue.getValue() != null) {
                        jsonWriter.key(attributesListValue.getKey());

                        jsonWriter.value(attributesListValue.getValue());
                    }
                }
                jsonWriter.endObject();
            }
            if (updateLayerRequest.getCustomInstanceProfileArn() != null) {
                jsonWriter.key("CustomInstanceProfileArn").value(updateLayerRequest.getCustomInstanceProfileArn());
            }

            java.util.List<String> customSecurityGroupIdsList = updateLayerRequest.getCustomSecurityGroupIds();
            if (customSecurityGroupIdsList != null && customSecurityGroupIdsList.size() > 0) {

                jsonWriter.key("CustomSecurityGroupIds");
                jsonWriter.array();

                for (String customSecurityGroupIdsListValue : customSecurityGroupIdsList) {
                    if (customSecurityGroupIdsListValue != null) {
                        jsonWriter.value(customSecurityGroupIdsListValue);
                    }
                }
                jsonWriter.endArray();
            }

            java.util.List<String> packagesList = updateLayerRequest.getPackages();
            if (packagesList != null && packagesList.size() > 0) {

                jsonWriter.key("Packages");
                jsonWriter.array();

                for (String packagesListValue : packagesList) {
                    if (packagesListValue != null) {
                        jsonWriter.value(packagesListValue);
                    }
                }
                jsonWriter.endArray();
            }

            java.util.List<VolumeConfiguration> volumeConfigurationsList = updateLayerRequest.getVolumeConfigurations();
            if (volumeConfigurationsList != null && volumeConfigurationsList.size() > 0) {

                jsonWriter.key("VolumeConfigurations");
                jsonWriter.array();

                for (VolumeConfiguration volumeConfigurationsListValue : volumeConfigurationsList) {
                    if (volumeConfigurationsListValue != null) {
                        jsonWriter.object();
                        if (volumeConfigurationsListValue.getMountPoint() != null) {
                            jsonWriter.key("MountPoint").value(volumeConfigurationsListValue.getMountPoint());
                        }
                        if (volumeConfigurationsListValue.getRaidLevel() != null) {
                            jsonWriter.key("RaidLevel").value(volumeConfigurationsListValue.getRaidLevel());
                        }
                        if (volumeConfigurationsListValue.getNumberOfDisks() != null) {
                            jsonWriter.key("NumberOfDisks").value(volumeConfigurationsListValue.getNumberOfDisks());
                        }
                        if (volumeConfigurationsListValue.getSize() != null) {
                            jsonWriter.key("Size").value(volumeConfigurationsListValue.getSize());
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }
            if (updateLayerRequest.isEnableAutoHealing() != null) {
                jsonWriter.key("EnableAutoHealing").value(updateLayerRequest.isEnableAutoHealing());
            }
            if (updateLayerRequest.isAutoAssignElasticIps() != null) {
                jsonWriter.key("AutoAssignElasticIps").value(updateLayerRequest.isAutoAssignElasticIps());
            }
            Recipes customRecipes = updateLayerRequest.getCustomRecipes();
            if (customRecipes != null) {

                jsonWriter.key("CustomRecipes");
                jsonWriter.object();


                java.util.List<String> setupList = customRecipes.getSetup();
                if (setupList != null && setupList.size() > 0) {

                    jsonWriter.key("Setup");
                    jsonWriter.array();

                    for (String setupListValue : setupList) {
                        if (setupListValue != null) {
                            jsonWriter.value(setupListValue);
                        }
                    }
                    jsonWriter.endArray();
                }

                java.util.List<String> configureList = customRecipes.getConfigure();
                if (configureList != null && configureList.size() > 0) {

                    jsonWriter.key("Configure");
                    jsonWriter.array();

                    for (String configureListValue : configureList) {
                        if (configureListValue != null) {
                            jsonWriter.value(configureListValue);
                        }
                    }
                    jsonWriter.endArray();
                }

                java.util.List<String> deployList = customRecipes.getDeploy();
                if (deployList != null && deployList.size() > 0) {

                    jsonWriter.key("Deploy");
                    jsonWriter.array();

                    for (String deployListValue : deployList) {
                        if (deployListValue != null) {
                            jsonWriter.value(deployListValue);
                        }
                    }
                    jsonWriter.endArray();
                }

                java.util.List<String> undeployList = customRecipes.getUndeploy();
                if (undeployList != null && undeployList.size() > 0) {

                    jsonWriter.key("Undeploy");
                    jsonWriter.array();

                    for (String undeployListValue : undeployList) {
                        if (undeployListValue != null) {
                            jsonWriter.value(undeployListValue);
                        }
                    }
                    jsonWriter.endArray();
                }

                java.util.List<String> shutdownList = customRecipes.getShutdown();
                if (shutdownList != null && shutdownList.size() > 0) {

                    jsonWriter.key("Shutdown");
                    jsonWriter.array();

                    for (String shutdownListValue : shutdownList) {
                        if (shutdownListValue != null) {
                            jsonWriter.value(shutdownListValue);
                        }
                    }
                    jsonWriter.endArray();
                }
                jsonWriter.endObject();
            }

          jsonWriter.endObject();
          

          String snippet = stringWriter.toString();
          byte[] content = snippet.getBytes("UTF-8");
          request.setContent(new StringInputStream(snippet));
          request.addHeader("Content-Length", Integer.toString(content.length));
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }
        

        return request;
    }

    private String getString(String s) {
        if (s == null) return "";
        return s;
    }
}
