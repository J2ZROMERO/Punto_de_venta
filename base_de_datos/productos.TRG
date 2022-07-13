TYPE=TRIGGERS
triggers='CREATE DEFINER=`root`@`localhost` TRIGGER antes_borrar\nBEFORE delete \nON pv_canoa_segunda.productos  FOR EACH row\nbegin \n\n/*	INSERT INTO pv_canoa_segunda.productos_eliminados\n\n	(fk_usuario, fk_producto, product, tipo, razon, fecha)\n\n	  \n\nVALUES(NULL, NULL, NULL, NULL, "eliminado", now());\n\n	*/\n	\n	\n	\n	end'
sql_modes=1411383304
definers='root@localhost'
client_cs_names='utf8mb4'
connection_cl_names='utf8mb4_unicode_ci'
db_cl_names='latin1_swedish_ci'
created=165593168115
