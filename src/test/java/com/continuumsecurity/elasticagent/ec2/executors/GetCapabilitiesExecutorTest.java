/*
 * Copyright 2017 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This file incorporates changes by @continuumsecurity
 */

package com.continuumsecurity.elasticagent.ec2.executors;

import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetCapabilitiesExecutorTest {

    @Test
    public void shouldReturnResponse() throws Exception {
        GoPluginApiResponse response = new GetCapabilitiesExecutor().execute();

        assertThat(response.responseCode(), is(200));
        JSONObject expected = new JSONObject()
                .put("supports_plugin_status_report", true)
                .put("supports_cluster_status_report", true)
                .put("supports_agent_status_report", true);
        JSONAssert.assertEquals(expected, new JSONObject(response.responseBody()), true);
    }
}
