select doktor.meno, doktor.priezvisko, operacia.nazov
from m_osoba osoba
join m_operacie_pacienta operacie_pacienta on (osoba.rod_cislo = operacie_pacienta.rod_cislo)
join m_operacia operacia on (operacia.id = operacie_pacienta.id_operacia)
join m_osetrujuci_doktor osetrujuci_doktor  on (osetrujuci_doktor.id = operacie_pacienta.id)
join m_doktor doktor on (doktor.id = osetrujuci_doktor.id_doktor)
where osoba.rod_cislo like :rodCislo
