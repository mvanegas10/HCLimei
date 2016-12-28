import codecs

rfd = '/home/meili/Downloads/backup_db2016-12-27.sql'
wfd = '/home/meili/Downloads/backup.sql'

reader = codecs.open(rfd,'r','utf-8')
writer = codecs.open(wfd,'w','utf-8')

for rline in reader:
	new_line = rline.replace('date NOT NULL', 'date')
	new_line = new_line.replace('CREATE TABLE ', "SET sql_mode = 'ALLOW_INVALID_DATES'; \n CREATE TABLE ")
	new_line = new_line.replace('CREATE ALGORITHM=UNDEFINED DEFINER=`serapise_serapis`@`localhost`', "CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`")
	new_line = new_line.replace("'0000-00-00'","NULL")
	new_line = new_line.replace("'David Giraldo'","'Meili Vanegas'")
	new_line = new_line.replace("'dgiraldo'","'mvanegas10'")
	writer.write(new_line)

reader.close()
writer.close()
