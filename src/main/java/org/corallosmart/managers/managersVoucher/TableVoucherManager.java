package org.corallosmart.managers.managersVoucher;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.corallosmart.managers.managersUtils.TableManager;
import org.corallosmart.models.modelsContributo.Contributo;
import org.corallosmart.models.modelsUtente.Utente;
import org.corallosmart.models.modelsVoucher.Voucher;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TableVoucherManager extends TableManager implements VoucherManager{
    private static final ResultSetHandler<Voucher> SOS_MAPPER =
            new BeanHandler<>(Voucher.class);

    private static final ResultSetHandler<List<Voucher>> SOS_LIST_MAPPER =
            new BeanListHandler<>(Voucher.class);

    public TableVoucherManager(DataSource dataSource) {
        super(dataSource);
    }
}

