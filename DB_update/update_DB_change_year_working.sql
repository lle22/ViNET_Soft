-- disable the check_sale constraint in the employee table
ALTER TABLE PS_CHITIET NOCHECK CONSTRAINT FK_PS_ChiTiet_DM_VatTu
-- enable the check_sale constraint in the employee table
ALTER TABLE PS_CHITIET CHECK CONSTRAINT FK_PS_ChiTiet_DM_VatTu
2.  disable trigger set tinh trang = 1 to > 1. Table PS_CHUNGTU
