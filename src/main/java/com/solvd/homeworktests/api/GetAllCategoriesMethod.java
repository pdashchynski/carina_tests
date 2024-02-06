package com.solvd.homeworktests.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/products/categories", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/products/_getcat/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetAllCategoriesMethod extends AbstractApiMethodV2 {

    public GetAllCategoriesMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
