package pl.bak.Currency_converter.util;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.bak.Currency_converter.model.Currency;
import pl.bak.Currency_converter.uri.NbpPathApi;
import pl.bak.Currency_converter.uri.body_for_request.DataArrayObject;
import pl.bak.Currency_converter.uri.body_for_request.DataInMultiArray;
import pl.bak.Currency_converter.uri.body_for_request.DataSingleObject;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Component
public class BodyFromApi {
    private NbpPathApi pathApi;
    private final RestTemplate restTemplate;

    public BodyFromApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<Currency> getSingleBodyFromApi(String fromCurrency) {
        pathApi = new NbpPathApi();
        DataSingleObject currencyData = restTemplate.getForObject(pathApi.getSingleData() + fromCurrency, DataSingleObject.class);
        Optional<DataSingleObject> singleObjectOptional = Optional.ofNullable(currencyData);

        if (singleObjectOptional.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(new DataRequestMapper().mapFromRequestToCurrencyDto(currencyData));
    }

    public Set<DataInMultiArray> getAllBodyFromApi() {
        pathApi = new NbpPathApi();
        pathApi.setTableClass("A/");
        DataArrayObject[] objA = restTemplate.getForObject(pathApi.getAllData(), DataArrayObject[].class);
        pathApi.setTableClass("B/");
        DataArrayObject[] objB = restTemplate.getForObject(pathApi.getAllData(), DataArrayObject[].class);

        Set<DataInMultiArray> allData = new HashSet<>();

        allData.addAll(Objects.requireNonNull(objA)[0].getRates());
        allData.addAll(Objects.requireNonNull(objB)[0].getRates());

        return allData;
    }

}
