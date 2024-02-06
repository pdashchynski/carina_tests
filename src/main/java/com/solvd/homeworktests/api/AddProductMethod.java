package com.solvd.homeworktests.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/products/add", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/products/_add/rq.json")
@ResponseTemplatePath(path = "api/products/_add/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class AddProductMethod extends AbstractApiMethodV2 {

    public AddProductMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
