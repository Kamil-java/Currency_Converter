package pl.bak.Currency_converter.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.bak.Currency_converter.model.Currency;

@Repository
@Transactional(readOnly = true)
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
