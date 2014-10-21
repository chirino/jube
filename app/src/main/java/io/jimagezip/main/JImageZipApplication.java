/**
 *  Copyright 2005-2014 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.jimagezip.main;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import io.jimagezip.local.AutoScaler;
import io.jimagezip.local.LocalNodeController;
import io.jimagezip.local.LocalNodeModel;
import io.jimagezip.process.ProcessManager;
import io.jimagezip.process.service.ProcessManagerService;
import org.apache.cxf.feature.LoggingFeature;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.management.MalformedObjectNameException;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class JImageZipApplication extends Application {
    @Produces
    private JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();

    @Inject
    private LocalNodeController localNodeController;

    @Override
    public Set<Object> getSingletons() {
        return new HashSet<Object>(
                Arrays.asList(
                        localNodeController,
                        jacksonJsonProvider,
/*
    TODO
                    new SwaggerFeature(),
                    new EnableJMXFeature(),
*/
                        new LoggingFeature()
                )
        );
    }
}

