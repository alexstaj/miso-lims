-- add_archived_SVR
--StartNoTest
--StartNoTest
SELECT userId INTO @user FROM User WHERE loginName = 'admin';
SET @time = NOW();

INSERT INTO SampleValidRelationship (parentId, childId, createdBy, creationDate, updatedBy, lastUpdated, archived)
VALUES (
    (SELECT sampleClassId FROM SampleClass WHERE alias = 'gDNA (aliquot)'),
    (SELECT sampleClassId FROM SampleClass WHERE alias = 'gDNA_wga (aliquot)'),
    @user, @time, @user, @time, 1
);
--EndNoTest
--EndNoTest

-- more_kits
--StartNoTest
--StartNoTest
INSERT INTO KitDescriptor (name, description, version, manufacturer, partNumber, stockLevel, kitType, platformType, lastModifier) VALUES
('Genome Analyzer Kit','Prep Kit for Illumina Genome Analyzer Templates',0,'Illumina',0,0,'Library','Illumina',1),
('GA_ChipSeq','GA_ChipSeq',0,'Illumina',0,0,'Library','Illumina',1),
('GA_Genomic','GA_Genomic',0,'Illumina',0,0,'Library','Illumina',1),
('GA_RNA_Nla','GA_RNA_Nla',0,'Illumina',0,0,'Library','Illumina',1),
('GA_RNA_Dpn','GA_RNA_Dpn',0,'Illumina',0,0,'Library','Illumina',1),
('GA_Small_RNA','GA_Small_RNA',0,'Illumina',0,0,'Library','Illumina',1),
('GA_MP','GA_MP',0,'Illumina',0,0,'Library','Illumina',1),
('GA_Ready_to_Run','GA_Ready_to_Run',0,'Illumina',0,0,'Library','Illumina',1),
('GA_Other','GA_Other',0,'Illumina',0,0,'Library','Illumina',1),
('AB_Fragment','AB_Fragment',0,'Illumina',0,0,'Library','Illumina',1),
('AB_MP','AB_MP',0,'Illumina',0,0,'Library','Illumina',1),
('AB_SREK','AB_SREK',0,'Illumina',0,0,'Library','Illumina',1),
('AB_Other','AB_Other',0,'Illumina',0,0,'Library','Illumina',1),
('GA_mRNA','GA_mRNA',0,'Illumina',0,0,'Library','Illumina',1),
('HE_DGE','Heliscope Digital Gene Expression kit',0,'Illumina',0,0,'Library','Illumina',1),
('AB_STR','Applied Biosystems STR prep kit; replaces the SREK kit',0,'Illumina',0,0,'Library','Illumina',1),
('GA_Dir_mRNA','GA Directional Protocol, smRNA adapters are provided',0,'Illumina',0,0,'Library','Illumina',1),
('GA_TruSeq_Transcriptome','TruSeq prep kit used for transcriptome libraries',0,'Illumina',0,0,'Library','Illumina',1),
('Ion Plus Fragment Library Kit','Ion Plus Fragment Library Kit',0,'Illumina',0,0,'Library','Illumina',1),
('EncoreComplete_mRNA','A directional sequencing mRNA prep kit',0,'Illumina',0,0,'Library','Illumina',1),
('EncoreComplete_WT','A directional WT prep kit',0,'Illumina',0,0,'Library','Illumina',1),
('Dynabeads_mRNA','Dynabeads_mRNA',0,'Illumina',0,0,'Library','Illumina',1),
('AmpliSeq Comprehensive Cancer Panel','Associated with Ion Torrent Libraries.',0,'Ion Torrent',0,0,'Library','Illumina',1),
('AmpliSeq Cancer Panel V1','Ion AmpliSeq Cancer Hotspot Panel V1',1,'Illumina',0,0,'Library','Illumina',1),
('Ovation RNA V2','cDNA synthesis and amplification.',0,'Illumina',0,0,'Library','Illumina',1),
('Encore Rapid Library','cDNA Library Prep',0,'Illumina',0,0,'Library','Illumina',1),
('AmpliSeq Custom Cancer Panel','AmpliSeq Custom Cancer Panel',0,'Illumina',0,0,'Library','Illumina',1),
('HALO','HALO',0,'Illumina',0,0,'Library','Illumina',1),
('NeoNano350','NeoNano350',0,'Illumina',0,0,'Library','Illumina',1),
('NeoNano550','NeoNano550',0,'Illumina',0,0,'Library','Illumina',1),
('Kapa Hyper Prep Plus','enzymatic fragmentation',0,'Illumina',0,0,'Library','Illumina',1),
('Agilent SureSelectXT MethylSeq','Agilent SureSelectXT Human Methyl-Seq targets the most complete content for methylation sequencing, including cancer tissue-specific DMRs, GENCODE promoters, CpG islands, shores and shelves ±4kb, DNaseI hypersensitive sites and RefGenes.',0,'Agilent',0,0,'Library','Illumina',1),
('Roche SeqCap Epi CpGiant','The SeqCap Epi CpGiant Enrichment Kits, as part of the SeqCap Epi Enrichment System, enables the targeting of selected genomic regions from bisulfite treated genomic DNA in a single workflow.',0,'Roche',0,0,'Library','Illumina',1),
('Swift Accel-NGS 2S','The Accel-NGS 2S PCR-free DNA Library Kit for Illumina platforms enables preparation of high complexity NGS libraries from double-stranded DNA.',0,'Illumina',0,0,'Library','Illumina',1),
('Agilent SureSelect Human All Exon V6 Cosmic','Agilent SureSelect Human All Exon V6 + Cosmic',0,'Agilent',0,0,'Library','Illumina',1),
('IDT xGEN Exome Research Panel v1','IDT xGEN Exome Research Panel v1.0',1,'Illumina',0,0,'Library','Illumina',1),
('Roche SeqCap EZ Exome v3','Roche SeqCap EZ Exome v3.0',3,'Roche',0,0,'Library','Illumina',1),
('Smarter Stranded Total Pico Mammalian','A unique, sensitive, and ligation-free method to generate stranded, Illumina-ready cDNA libraries from an input range of 250 pg–10 ng of total mammalian RNA in about 5 hours',0,'Illumina',0,0,'Library','Illumina',1);
--EndNoTest
--EndNoTest

-- archived_lcm_relationships
--StartNoTest
--StartNoTest
SELECT userId INTO @user FROM User WHERE loginName = 'admin';
SET @time = NOW();

INSERT INTO SampleValidRelationship (parentId, childId, createdBy, creationDate, updatedBy, lastUpdated, archived)
VALUES (
    (SELECT sampleClassId FROM SampleClass WHERE alias = 'Primary Tumor Tissue'),
    (SELECT sampleClassId FROM SampleClass WHERE alias = 'LCM Tube'),
    @user, @time, @user, @time, 1
);

INSERT INTO SampleValidRelationship (parentId, childId, createdBy, creationDate, updatedBy, lastUpdated, archived)
VALUES (
    (SELECT sampleClassId FROM SampleClass WHERE alias = 'Xenograft Tissue'),
    (SELECT sampleClassId FROM SampleClass WHERE alias = 'LCM Tube'),
    @user, @time, @user, @time, 1
);
--EndNoTest
--EndNoTest

-- ga_truseq_lib_kit
--StartNoTest
INSERT INTO KitDescriptor(name, version, manufacturer, partNumber, stockLevel, kitType, platformType, description, lastModifier)
 VALUES ('GA_TruSeq_Library', 0, 'Illumina', 1, 0, 'Library', 'Illumina', 'TruSeq Genomic Library prep kit', 1);
--EndNoTest

