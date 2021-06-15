package pl.bak.Currency_converter.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.bak.Currency_converter.model.Currency;
import pl.bak.Currency_converter.uri.body_for_request.DataInMultiArray;

import java.math.BigDecimal;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/all")
    public Set<DataInMultiArray> allData() {
        Set<DataInMultiArray> all = currencyService.getAll();

        if (all.size() == 0){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return all;
    }

    @PostMapping("/sell")
    public Currency sellCurrency(@RequestParam("fromCode") String fromCode, @RequestParam("toCode") String toCode,
                                    @RequestParam("value") double value) {
        fromCode = fromCode.toUpperCase();
        toCode = toCode.toUpperCase();

        if (fromCode.equals(toCode)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (currencyService.checkIfCodeIsSupported(fromCode, toCode)) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        BigDecimal decimal = BigDecimal.valueOf(value);
        if (decimal.compareTo(BigDecimal.ZERO) < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return currencyService.sellCurrency(fromCode, toCode, decimal)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PostMapping("/purchase")
    public Currency purchaseCurrency(@RequestParam("fromCode") String fromCode, @RequestParam("toCode") String toCode,
                                    @RequestParam("value") double value) {
        fromCode = fromCode.toUpperCase();
        toCode = toCode.toUpperCase();

        if (fromCode.equals(toCode)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (currencyService.checkIfCodeIsSupported(fromCode, toCode)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        BigDecimal decimal = BigDecimal.valueOf(value);
        if (decimal.compareTo(BigDecimal.ZERO) < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return currencyService.purchaseCurrency(fromCode, toCode, decimal)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
