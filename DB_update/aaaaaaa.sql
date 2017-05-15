SELECT COUNT(*) FROM DM_VATTU 

SELECT * FROM PS_CHITIET WHERE VAtTUID not in (SELECT ID FROM DM_VATTU)

SELECT * FROM DM_VATTU WHERE id = ' '

SELECT * FROM PS_DONHANGCHITIET WHERE VAtTUID is null

select * from sysobjects
where xtype = 'F'

select
  so.name 'FK_PS_ChiTiet_DM_VatTu',
  OBJECT_NAME(parent_obj) 'table',
  OBJECT_NAME(sf.fkeyid) 'referencing table',
  sc1.name 'referencing column',
  OBJECT_NAME(sf.rkeyid) 'referenced table',
  sc2.name 'referenced column'
from sysobjects so
inner join sysforeignkeys sf on so.id = sf.constid
inner join syscolumns sc1 on sf.fkeyid = sc1.id and sf.fkey = sc1.colid
inner join syscolumns sc2 on sf.rkeyid = sc2.id and sf.fkey = sc2.colid
where so.xtype in ('F','PK') AND  OBJECT_NAME(sf.rkeyid) = 'DM_VATTU'

SELECT * FROM PS_ChiTiet

 WHERE VATTUID is null

-- disable the check_sale constraint in the employee table
ALTER TABLE PS_CHITIET NOCHECK CONSTRAINT FK_PS_ChiTiet_DM_VatTu

-- enable the check_sale constraint in the employee table
ALTER TABLE PS_CHITIET CHECK CONSTRAINT FK_PS_ChiTiet_DM_VatTu
